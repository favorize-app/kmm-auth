package multi.platform.auth.app.signin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.facebook.AccessToken
import com.facebook.BuildConfig
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.LoggingBehavior
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import multi.platform.auth.R
import multi.platform.auth.databinding.SigninFragmentBinding
import multi.platform.auth.shared.app.signin.SignInViewModel
import multi.platform.auth.shared.external.constant.AuthConstant
import multi.platform.auth.shared.external.utility.CountryCodeUtil
import multi.platform.core.shared.app.common.BaseFragment
import multi.platform.core.shared.domain.common.entity.Ticket
import multi.platform.core.shared.external.constant.AppConstant
import multi.platform.core.shared.external.extension.goTo
import multi.platform.core.shared.external.extension.showErrorSnackbar
import multi.platform.core.shared.external.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber


class SignInFragment : BaseFragment<SigninFragmentBinding>(
    R.layout.signin_fragment
) {

    private val vm: SignInViewModel by viewModel()
    private val defaultCountryCode by lazy {
        CountryCodeUtil.getCountryCodes(requireContext(), getString(R.string.country_codes_list))
            .find {
                it.dialCode == getString(R.string.country_codes_default_code)
            }
    }
    private val callbackManager: CallbackManager by lazy {
        CallbackManager.Factory.create()
    }

    override fun showActionBar() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(AuthConstant.SIGN_IN_REQ) { _, b ->
            if (b.getBoolean(AuthConstant.SIGN_IN_REQ)) findNavController().navigateUp()
        }
        setFragmentResultListener(AuthConstant.VERIFY_REQ) { _, b ->
            Handler(Looper.getMainLooper()).postDelayed({
                goTo(
                    getString(R.string.route_register)
                        .replace("{country}", b.getString(AuthConstant.COUNTRY, ""))
                        .replace("{phone}", b.getString(AuthConstant.PHONE, ""))
                        .replace("{transactionId}", b.getString(AuthConstant.TRANSACTION_ID, ""))
                )
            }, 300)
        }
    }

    @Suppress("kotlin:S1186")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm

        val scope = viewLifecycleOwner.lifecycleScope
        scope.launchWhenResumed { vm.loadingIndicator.collect { showFullLoading(it) } }
        scope.launchWhenResumed { vm.errorMessage.collect { showErrorSnackbar(it) } }
        scope.launchWhenResumed { vm.toastMessage.collect { showToast(it) } }
        scope.launchWhenResumed { vm.onSignedIn.collect { onSignedIn(it) } }
        scope.launchWhenResumed { vm.onCheckPhone.collect { onCheckPhone(it) } }
        scope.launchWhenResumed { vm.signInByGoogleTrigger.collect { signInByGoogle(it) } }
        scope.launchWhenResumed { vm.signInByFacebookTrigger.collect { signInByFacebook(it) } }

        binding.phoneForm.etPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                vm.phoneValidate(
                    getString(R.string.country_codes_default_code),
                    R.string.signin_phone_error_min_character,
                    R.string.signin_phone_error_format
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (vm.country.value == defaultCountryCode?.dialCode && s.toString() == "0") {
                    binding.phoneForm.etPhone.removeTextChangedListener(this)
                    binding.phoneForm.etPhone.setText("")
                    binding.phoneForm.etPhone.addTextChangedListener(this)
                }
            }
        })
        defaultCountryCode?.let {
            vm.country.value = it.dialCode
        }
    }

    private fun onSignedIn(ticket: Ticket?) {
        ticket?.let {
            sharedPreferences.edit()
                .putString(AppConstant.ACCESS_TOKEN, it.session?.token)
                .putString(AppConstant.REFRESH_TOKEN, it.session?.refreshToken)
                .apply()
            findNavController().navigateUp()
        }
    }

    private fun onCheckPhone(ticket: Ticket?) {
        ticket?.let { t ->
            val verifyOtp = getString(R.string.route_otp)
                .replace("{state}", t.state.toString())
                .replace("{country}", vm.country.value.toString())
                .replace("{phone}", vm.phone.value.toString())
                .replace("{duration}", t.otp?.duration.toString())
                .replace("{transactionId}", t.transactionId.toString())
            goTo(verifyOtp)
        }
    }

    private fun signInByGoogle(trigger: Boolean?) {
        if (trigger == true) {
            val googleWebClientId = getString(R.string.GOOGLE_WEB_CLIENT_ID)
            if (googleWebClientId.isEmpty()) {
                vm.toastMessage.value = "Google web client ID not found"
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
                    vm.onGetAccessToken("google", account.idToken.toString())
                } catch (e: ApiException) {
                    Timber.e("signInResult:failed code=" + e.statusCode)
                }
            }
        }

    private fun signInByFacebook(trigger: Boolean?) {
        if (trigger == true) {
            val fbAppId = getString(R.string.FB_APP_ID)
            if (fbAppId.isEmpty()) {
                vm.toastMessage.value = "Facebook app ID not found"
                return
            }
            if (BuildConfig.DEBUG) {
                FacebookSdk.setIsDebugEnabled(true)
                FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS)
            }

            LoginManager.getInstance()
                .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult) {
                        vm.onGetAccessToken("facebook", result.accessToken.token)
                    }

                    override fun onCancel() {
                        vm.loadingIndicator.value = false
                        Timber.d("Login cancelled")
                    }

                    override fun onError(error: FacebookException) {
                        vm.onGetAccessTokenFail(error.message)
                    }
                })

            val accessToken = AccessToken.getCurrentAccessToken()
            if (accessToken != null && !accessToken.isExpired) {
                vm.onGetAccessToken("facebook", accessToken.toString())
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