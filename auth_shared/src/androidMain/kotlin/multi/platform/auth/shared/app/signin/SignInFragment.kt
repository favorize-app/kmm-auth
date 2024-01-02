package multi.platform.auth.shared.app.signin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.fragment.findNavController
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.GraphRequest
import com.facebook.LoggingBehavior
import com.facebook.login.LoginBehavior
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.onesignal.OneSignal
import multi.platform.auth.shared.BuildConfig
import multi.platform.auth.shared.R
import multi.platform.auth.shared.data.auth.network.payload.UserPayload
import multi.platform.auth.shared.databinding.SigninFragmentBinding
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.constants.AuthKey
import multi.platform.auth.shared.external.enums.AuthType
import multi.platform.auth.shared.external.utilities.BiometricUtil
import multi.platform.core.shared.app.common.CoreFragment
import multi.platform.core.shared.external.constants.CommonKey
import multi.platform.core.shared.external.extensions.goTo
import multi.platform.core.shared.external.extensions.launchAndCollectIn
import multi.platform.core.shared.external.extensions.showErrorSnackbar
import multi.platform.core.shared.external.extensions.showToast
import multi.platform.core.shared.external.utilities.Persistent
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.inject
import java.util.UUID
import multi.platform.core.shared.R as cR

class SignInFragment : CoreFragment() {

    private val minChar = 9
    private val authConfig: AuthConfig by inject()
    private val signInViewModel: SignInViewModel by viewModel()
    private val persistent: Persistent by inject()
    private lateinit var binding: SigninFragmentBinding
    private val callbackManager: CallbackManager by lazy {
        CallbackManager.Factory.create()
    }
    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var otherAuthToken: String
    private var otherAuthType: AuthType? = null
    private var userPayload: UserPayload? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener(AuthKey.SIGN_IN_KEY) { _, b ->
            if (b.getBoolean(AuthKey.SIGN_IN_KEY)) findNavController().navigateUp()
        }
        setFragmentResultListener(AuthKey.VERIFY_KEY) { _, b ->
            Handler(Looper.getMainLooper()).postDelayed({
                goToRegister(
                    b.getString(AuthKey.COUNTRY_KEY, ""),
                    b.getString(AuthKey.TRANSACTION_ID, ""),
                    b.getString(CommonKey.PHONE_KEY, null),
                )
            }, 300)
        }
        setFragmentResultListener(CommonKey.RETRY_KEY) { _, b ->
            if (b.getString(CommonKey.RETRY_KEY, "") == AuthKey.SIGN_IN_KEY) {
                Handler(Looper.getMainLooper()).postDelayed({ submit() }, 300)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.signin_fragment, container, false)
        return binding.root
    }

    @Suppress("kotlin:S1186")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedStateHandle = findNavController().currentBackStackEntry!!.savedStateHandle
        savedStateHandle[AuthKey.SIGN_IN_KEY] = false
        setupObserver()
        setupView()
    }

    private fun setupObserver() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.authConfig = authConfig
        binding.vm = signInViewModel.also {
            if (!authConfig.signInByEmailApi.isEmpty()) it.authType.value = AuthType.EMAIL
            if (!authConfig.signInByPhoneApi.isEmpty()) it.authType.value = AuthType.PHONE

            it.country.value = authConfig.countryCode
            it.errorMinChar = getString(cR.string.error_min_character, minChar)
            it.errorPhoneFormat = getString(cR.string.error_phone_format)
            it.errorEmptyField = getString(cR.string.error_empty_field)
            it.errorEmailFormat = getString(cR.string.error_email_format)
            it.loadingIndicator.launchAndCollectIn(this, Lifecycle.State.STARTED) { l ->
                l?.let {
                    binding.loadingView.clLoading.isVisible = l
                    binding.loadingView.lpiLoading.isVisible = l
                }
                it.loadingIndicator.value = null
            }
            it.errorMessage.launchAndCollectIn(this, Lifecycle.State.STARTED) { m ->
                showErrorSnackbar(binding.root, m)
                it.errorMessage.value = null
            }
            it.toastMessage.launchAndCollectIn(this, Lifecycle.State.STARTED) { m ->
                showToast(m)
                it.toastMessage.value = null
            }
            it.onSignedIn.launchAndCollectIn(this, Lifecycle.State.STARTED) { t ->
                otherAuthType = null
                onSignedIn(t)
                it.onSignedIn.value = null
            }
            it.onCheckPhone.launchAndCollectIn(this, Lifecycle.State.STARTED) { t ->
                otherAuthType = null
                onCheckPhone(t)
                it.onCheckPhone.value = null
            }
            it.onSignInByGoogleClick.launchAndCollectIn(this, Lifecycle.State.STARTED) { t ->
                otherAuthType = AuthType.GOOGLE
                onSignInByGoogle(t)
                it.onSignInByGoogleClick.value = null
            }
            it.onSignInByFacebookClick.launchAndCollectIn(this, Lifecycle.State.STARTED) { t ->
                otherAuthType = AuthType.FACEBOOK
                onSignInByFacebook(t)
                it.onSignInByFacebookClick.value = null
            }
            it.onSignInByBiometricClick.launchAndCollectIn(this, Lifecycle.State.STARTED) { t ->
                otherAuthType = AuthType.BIOMETRIC
                t?.let { _ ->
                    BiometricUtil(requireContext(), "AndroidKeyStore") { token ->
                        otherAuthToken = token
                        userPayload = null
                        it.onGetAccessToken(otherAuthType!!, otherAuthToken, userPayload)
                    }.show()
                }
                it.onSignInByBiometricClick.value = null
            }
            it.onGoToRegisterClick.launchAndCollectIn(this, Lifecycle.State.STARTED) { g ->
                g?.let {
                    goToRegister(
                        signInViewModel.country.value.toString(),
                        UUID.randomUUID().toString(),
                    )
                }
                it.onGoToRegisterClick.value = null
            }
            it.onGoToForgetPasswordClick.launchAndCollectIn(
                this,
                Lifecycle.State.STARTED,
            ) { g ->
                g?.let { goTo(getString(R.string.route_auth_forget_password)) }
                it.onGoToForgetPasswordClick.value = null
            }
            it.onException.launchAndCollectIn(this, Lifecycle.State.STARTED) { e ->
                e?.let {
                    goTo(
                        getString(R.string.route_auth_error_connection).replace(
                            "{key}",
                            AuthKey.SIGN_IN_KEY,
                        ),
                    )
                }
                it.onException.value = null
            }
        }
    }

    private fun setupView() {
        binding.ivLogo.setImageResource(authConfig.logo)
        binding.emailForm.apply {
            etEmail.doAfterTextChanged {
                signInViewModel.validateBlank(signInViewModel.email, signInViewModel.emailError)
                signInViewModel.validateEmailFormat(
                    signInViewModel.email,
                    signInViewModel.emailError,
                )
            }
            etPassword.doAfterTextChanged {
                signInViewModel.validateBlank(
                    signInViewModel.password,
                    signInViewModel.passwordError,
                )
            }
        }

        binding.phoneForm.apply {
            etCountry.setCompoundDrawablesRelativeWithIntrinsicBounds(
                authConfig.countryFlag,
                0,
                0,
                0,
            )
            etPhone.apply {
                doAfterTextChanged {
                    signInViewModel.validatePhoneFormat(
                        signInViewModel.phone,
                        signInViewModel.phoneError,
                    )
                    signInViewModel.validateMinChar(
                        minChar,
                        signInViewModel.phone,
                        signInViewModel.phoneError,
                    )
                }
                doOnTextChanged { text, _, _, _ ->
                    if (signInViewModel.country.value == authConfig.countryCode && text.toString() == "0") {
                        binding.phoneForm.etPhone.setText("")
                    }
                }
            }
        }

        setupSigInProviderView()
    }

    private fun setupSigInProviderView() {
        if (authConfig.signInByPhoneApi.isEmpty() || authConfig.signInByEmailApi.isEmpty()) {
            binding.mbToggle.isVisible = false
        }
        if (authConfig.signInByProviderApi.isEmpty()) {
            binding.mbGoogle.isVisible = false
            binding.mbFacebook.isVisible = false
            binding.mbBiometric.isVisible = false
        }
        if (!binding.mbToggle.isVisible && !binding.mbGoogle.isVisible && !binding.mbFacebook.isVisible && !binding.mbBiometric.isVisible) {
            binding.mtvOr.isVisible = false
            binding.leftOrLine.isVisible = false
            binding.rightOrLine.isVisible = false
        }
    }

    private fun submit() {
        if (otherAuthType != null) {
            signInViewModel.onGetAccessToken(otherAuthType!!, otherAuthToken, userPayload)
        } else {
            if (signInViewModel.authType.value == AuthType.EMAIL) {
                signInViewModel.signInEmail()
            } else signInViewModel.signInPhone()
        }
    }

    private fun goToRegister(country: String, transactionId: String, phone: String? = null) {
        val routeAuthRegister =
            getString(R.string.route_auth_register).replace("{country}", country)
                .replace("{transactionId}", transactionId)
        phone?.let { routeAuthRegister.replace("{phone}", it) }
        goTo(routeAuthRegister)
    }

    private fun onSignedIn(ticket: Ticket?) {
        ticket?.let {
            savedStateHandle[AuthKey.SIGN_IN_KEY] = true
            it.session?.token?.let { t -> persistent.putString(CommonKey.ACCESS_TOKEN_KEY, t) }
            it.session?.refreshToken?.let { r ->
                persistent.putString(
                    CommonKey.REFRESH_TOKEN_KEY,
                    r,
                )
            }
            it.session?.msisdn?.let { m -> persistent.putString(CommonKey.PHONE_KEY, m) }
            if (authConfig.onesignalAppId.isNotEmpty()) {
                OneSignal.login(ticket.session?.id.toString())
                ticket.session?.email?.let { e ->
                    OneSignal.User.addEmail(e)
                }
                ticket.session?.msisdn?.let { p ->
                    OneSignal.User.addSms(p)
                }
            }
            showToast(getString(R.string.signin_welcome_back, it.session?.fullname))
            findNavController().navigateUp()
        }
    }

    private fun onCheckPhone(ticket: Ticket?) {
        ticket?.let { t ->
            goTo(
                getString(R.string.route_auth_otp).replace("{state}", t.state.toString())
                    .replace("{country}", signInViewModel.country.value.toString())
                    .replace("{phone}", signInViewModel.phone.value.toString())
                    .replace("{duration}", t.otp?.duration.toString())
                    .replace("{transactionId}", t.transactionId.toString()),
            )
        }
    }

    private fun onSignInByGoogle(trigger: Boolean?) {
        if (trigger == true) {
            if (authConfig.googleWebClientId.isEmpty()) {
                signInViewModel.toastMessage.value = "Google web client ID not found"
                return
            }
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(authConfig.googleWebClientId).requestEmail().build()
            val mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
            val signInIntent = mGoogleSignInClient.signInIntent
            resultGoogleSignIn.launch(signInIntent)
        }
    }

    private var resultGoogleSignIn =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            try {
                val data: Intent? = result.data
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
                userPayload = UserPayload(fullname = account.displayName, email = account.email)
                otherAuthToken = account.idToken.toString()
                signInViewModel.onGetAccessToken(otherAuthType!!, otherAuthToken, userPayload)
            } catch (e: ApiException) {
                e.printStackTrace()
                signInViewModel.errorMessage.value = getString(R.string.signin_google_error)
            }
        }

    private fun onSignInByFacebook(trigger: Boolean?) {
        if (trigger == true) {
            if (authConfig.fbAppId.isEmpty()) {
                signInViewModel.toastMessage.value = "Facebook app ID not found"
                return
            }
            if (BuildConfig.DEBUG) {
                FacebookSdk.setIsDebugEnabled(true)
                FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS)
            }

            val fbLoginManager = LoginManager.getInstance()
            fbLoginManager.setLoginBehavior(LoginBehavior.WEB_ONLY)
            fbLoginManager.registerCallback(
                callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(result: LoginResult) {
                        signInByFacebookToken(result.accessToken)
                    }

                    override fun onCancel() {
                        signInViewModel.loadingIndicator.value = false
                    }

                    override fun onError(error: FacebookException) {
                        signInViewModel.loadingIndicator.value = false
                        signInViewModel.errorMessage.value =
                            getString(R.string.signin_facebook_error)
                    }
                },
            )

            val accessToken = AccessToken.getCurrentAccessToken()
            if (accessToken != null && !accessToken.isExpired) {
                signInByFacebookToken(accessToken)
            } else {
                LoginManager.getInstance().logInWithReadPermissions(
                    this,
                    callbackManager,
                    listOf("public_profile", "email"),
                )
            }
        }
    }

    private fun signInByFacebookToken(accessToken: AccessToken) {
        val request =
            GraphRequest.newMeRequest(accessToken) { _, response ->
                try {
                    val name = response?.getJSONObject()?.getString("name")
                    val email = response?.getJSONObject()?.getString("email")
                    userPayload = UserPayload(fullname = name, email = email)
                    otherAuthToken = accessToken.toString()
                    signInViewModel.onGetAccessToken(
                        otherAuthType!!,
                        otherAuthToken,
                        userPayload,
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                    signInViewModel.errorMessage.value =
                        getString(R.string.signin_facebook_error)
                }
            }
        val parameters = Bundle()
        parameters.putString("fields", "id,name,email,gender,birthday")
        request.parameters = parameters
        request.executeAsync()
    }
}
