package tossaro.android.auth.app.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.biometric.BiometricManager
import androidx.navigation.NavOptions
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import tossaro.android.auth.AuthRouters
import tossaro.android.auth.R
import tossaro.android.auth.databinding.SigninFragmentBinding
import tossaro.android.auth.external.utility.CountryCodeUtil
import tossaro.android.core.app.BaseFragment
import tossaro.android.core.domain.entity.Ticket
import tossaro.android.core.external.ext.goTo
import tossaro.android.core.external.ext.showToast


class SignInFragment : BaseFragment<SigninFragmentBinding>(
    R.layout.signin_fragment
) {

    private var doubleBackToExitPressedOnce = false
    private val viewModel: SignInViewModel by viewModel()
    private val defaultCountryCode by lazy {
        CountryCodeUtil.getCountryCodes(requireContext()).find {
            it.dialCode == getString(R.string.country_codes_default_code)
        }
    }
    val callbackManager: CallbackManager by lazy {
        CallbackManager.Factory.create()
    }

    override fun actionBarTitle() = getString(R.string.sign_in_title)
    override fun isBottomNavBarShown() = false

    override fun onBackPressed(): Boolean {
        if (doubleBackToExitPressedOnce) {
            activity?.finish()
            return true
        }

        doubleBackToExitPressedOnce = true
        Toast.makeText(
            context,
            getString(R.string.tap_to_minimize),
            Toast.LENGTH_SHORT
        ).show()

        Handler(Looper.getMainLooper()).postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
        return false
    }

    @Suppress("kotlin:S1186")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel.also {
            it.sharedPrefs.value = sharedPreferences
            it.loadingIndicator.observe(viewLifecycleOwner, ::showFullLoading)
            it.alertMessage.observe(viewLifecycleOwner, ::showToast)
            it.onSignedIn.observe(viewLifecycleOwner, ::onSignedIn)
            it.onCheckPhone.observe(viewLifecycleOwner, ::onCheckPhone)
            it.signInByGoogleTrigger.observe(viewLifecycleOwner, ::signInByGoogle)
            it.signInByFacebookTrigger.observe(viewLifecycleOwner, ::signInByFacebook)
        }
        binding.phoneForm.etPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.phoneValidate(getString(R.string.country_codes_default_code))
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        binding.emailForm.etEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.emailValidate()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        binding.emailForm.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.passwordValidate()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        defaultCountryCode?.let {
            viewModel.country.value = it.dialCode
        }
        activity?.let {
            it.application?.let { app ->
                if (BiometricManager.from(app)
                        .canAuthenticate() != BiometricManager.BIOMETRIC_SUCCESS
                ) binding.btnFingerPrint.isEnabled = false
            }
        }
    }

    private fun onSignedIn(path: String) {
        goTo(
            path,
            NavOptions.Builder().setPopUpTo(tossaro.android.core.R.id.splashFragment, true).build()
        )
    }

    private fun onCheckPhone(ticket: Ticket?) {
        ticket?.let {
            goTo(
                AuthRouters.OTP
                    .replace("{type}", ticket.type.toString())
                    .replace("{country}", viewModel.country.value.toString())
                    .replace("{phone}", viewModel.phone.value.toString())
                    .replace("{duration}", it.duration.toString())
                    .replace("{ticketId}", it.ticketId)
            )
        }
    }

    private fun signInByGoogle(trigger: Boolean) {
        if (trigger) {
            val googleWebClientId = getString(R.string.GOOGLE_WEB_CLIENT_ID)
            if (googleWebClientId.isEmpty()) {
                viewModel.alertMessage.value = "Google web client ID not found"
                return
            }
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(googleWebClientId)
                .requestEmail()
                .build()
            val mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
            val signInIntent = mGoogleSignInClient.signInIntent
            resultGoogleSignIn.launch(signInIntent)
        }
    }

    private var resultGoogleSignIn =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
                    viewModel.onGetAccessToken("google", account.idToken.toString())
                } catch (e: ApiException) {
                    Timber.e("signInResult:failed code=" + e.statusCode)
                }
            }
        }

    private fun signInByFacebook(trigger: Boolean) {
        if (trigger) {
            val fbAppId = getString(R.string.FB_APP_ID)
            if (fbAppId.isEmpty()) {
                viewModel.alertMessage.value = "Facebook app ID not found"
                return
            }
            if (BuildConfig.DEBUG) {
                FacebookSdk.setIsDebugEnabled(true)
                FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS)
            }

            LoginManager.getInstance()
                .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult) {
                        viewModel.onGetAccessToken("facebook", result.accessToken.token)
                    }

                    override fun onCancel() {
                        viewModel.loadingIndicator.value = false
                        Timber.d("Login cancelled")
                    }

                    override fun onError(error: FacebookException) {
                        viewModel.onGetAccessTokenFail(error.message)
                    }
                })

            val accessToken = AccessToken.getCurrentAccessToken()
            if (accessToken != null && !accessToken.isExpired) {
                viewModel.onGetAccessToken("facebook", accessToken.toString())
            } else {
                LoginManager.getInstance()
                    .logInWithReadPermissions(
                        this,
                        callbackManager,
                        listOf("public_profile", "email")
                    )
            }
        }
    }
}