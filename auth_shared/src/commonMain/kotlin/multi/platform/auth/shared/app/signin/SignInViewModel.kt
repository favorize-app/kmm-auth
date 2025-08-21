package multi.platform.auth.shared.app.signin

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.io.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import multi.platform.auth.shared.data.auth.network.payload.UserPayload
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.domain.auth.usecase.AuthorizationUseCase
import multi.platform.auth.shared.domain.auth.usecase.SignInEmailUseCase
import multi.platform.auth.shared.domain.auth.usecase.SignInProviderUseCase
import multi.platform.auth.shared.domain.auth.usecase.ValidatePhoneUseCase
import multi.platform.auth.shared.external.enums.AuthType
import multi.platform.auth.shared.base.BaseViewModel
import multi.platform.auth.shared.domain.auth.usecase.SignInProviderParams
import multi.platform.auth.shared.external.errors.AuthError

@Suppress("KOTLIN:S6305")
class SignInViewModel(
    private val authorizationUseCase: AuthorizationUseCase,
    private val validatePhoneUseCase: ValidatePhoneUseCase,
    private val signInEmailUseCase: SignInEmailUseCase,
    private val signInProviderUseCase: SignInProviderUseCase,
) : BaseViewModel() {
    
    // Original StateFlow properties (keeping for backward compatibility)
    val onCheckPhone = MutableStateFlow<Ticket?>(null)
    val authType = MutableStateFlow<AuthType?>(null)
    val country = MutableStateFlow<String?>(null)
    val phone = MutableStateFlow<String?>(null)
    val phoneError = MutableStateFlow<String?>(null)
    val email = MutableStateFlow<String?>(null)
    val emailError = MutableStateFlow<String?>(null)
    val password = MutableStateFlow<String?>(null)
    val passwordError = MutableStateFlow<String?>(null)
    val onSignedIn = MutableStateFlow<Ticket?>(null)
    val onSignInByGoogleClick = MutableStateFlow<Boolean?>(null)
    val onSignInByFacebookClick = MutableStateFlow<Boolean?>(null)
    val onSignInByBiometricClick = MutableStateFlow<Boolean?>(null)
    val onGoToForgetPasswordClick = MutableStateFlow<Boolean?>(null)
    val onGoToRegisterClick = MutableStateFlow<Boolean?>(null)
    
    // New consolidated state (for future use)
    private val _state = MutableStateFlow(SignInState())
    val state: StateFlow<SignInState> = _state
    
    // State update helpers
    private fun updateState(update: (SignInState) -> SignInState) {
        _state.value = update(_state.value)
    }
    
    // New state update methods
    fun updatePhone(phone: String) {
        this.phone.value = phone
        phoneError.value = null
        updateState { it.copy(phone = phone, phoneError = null) }
    }
    
    fun updateEmail(email: String) {
        this.email.value = email
        emailError.value = null
        updateState { it.copy(email = email, emailError = null) }
    }
    
    fun updatePassword(password: String) {
        this.password.value = password
        passwordError.value = null
        updateState { it.copy(password = password, passwordError = null) }
    }
    
    fun updateCountry(country: String) {
        this.country.value = country
        updateState { it.copy(country = country) }
    }

    fun onGetAccessTokenFail(error: String?) {
        loadingIndicator.value = false
        toastMessage.value = error
    }

    fun goToForgotPassword() {
        loadingIndicator.value = false
        onGoToForgetPasswordClick.value = true
    }

    fun goToRegister() {
        loadingIndicator.value = false
        onGoToRegisterClick.value = true
    }

    private fun saveTokenLocal(ticket: Ticket?) {
        loadingIndicator.value = false
        onSignedIn.value = ticket
    }

    fun signInPhone() {
        if (country.value.isNullOrEmpty() || phone.value.isNullOrEmpty() || phoneError.value != null) return
        
        var coroutine = scope
        if (useAsyncNetworkCall) coroutine = CoroutineScope(Dispatchers.Default)
        
        loadingIndicator.value = true
        
        coroutine.launch {
            try {
                val response = authorizationUseCase.execute(country.value + phone.value)
                loadingIndicator.value = false
                onCheckPhone.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                loadingIndicator.value = false
                when (e) {
                    is ClientRequestException -> validatePhone()
                    is ServerResponseException, is IOException -> onException.value = e
                    else -> errorMessage.value = e.message
                }
            }
        }
    }

    private fun validatePhone() {
        scope.launch {
            try {
                val response = validatePhoneUseCase.execute(country.value + phone.value)
                loadingIndicator.value = false
                onCheckPhone.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                loadingIndicator.value = false
                when (e) {
                    is ServerResponseException, is IOException -> onException.value = e
                    else -> errorMessage.value = e.message
                }
            }
        }
    }

    fun signInEmail() {
        if (email.value.isNullOrEmpty() || password.value.isNullOrEmpty()) return
        scope.launch {
            loadingIndicator.value = true
            try {
                val response = signInEmailUseCase.execute(Pair(email.value.toString(), password.value.toString()))
                saveTokenLocal(response)
            } catch (e: Exception) {
                e.printStackTrace()
                loadingIndicator.value = false
                when (e) {
                    is ServerResponseException, is IOException -> onException.value = e
                    else -> errorMessage.value = e.message
                }
            }
        }
    }

    fun onGetAccessToken(authType: AuthType, accessToken: String, userPayload: UserPayload?) {
        scope.launch {
            loadingIndicator.value = true
            try {
                val response = signInProviderUseCase.execute(SignInProviderParams(authType, accessToken, userPayload))
                saveTokenLocal(response)
            } catch (e: Exception) {
                e.printStackTrace()
                loadingIndicator.value = false
                when (e) {
                    is ServerResponseException, is IOException -> onException.value = e
                    else -> errorMessage.value = e.message
                }
            }
        }
    }

    fun toggleForm() {
        authType.value = if (authType.value == AuthType.EMAIL) AuthType.PHONE else AuthType.EMAIL
    }

    fun signInByGoogle() {
        onSignInByGoogleClick.value = true
    }

    fun signInByFacebook() {
        onSignInByFacebookClick.value = true
    }

    fun sinInByBiometric() {
        onSignInByBiometricClick.value = true
    }
}
