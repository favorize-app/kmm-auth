package multi.platform.auth.shared.app.signin

import multi.platform.auth.shared.domain.user.usecase.AuthorizationUseCase
import multi.platform.auth.shared.domain.user.usecase.SignInEmailUseCase
import multi.platform.auth.shared.domain.user.usecase.SignInProviderUseCase
import multi.platform.auth.shared.domain.user.usecase.ValidationUseCase
import multi.platform.core.shared.app.common.BaseViewModel
import multi.platform.core.shared.domain.common.entity.Meta
import multi.platform.core.shared.domain.common.entity.Ticket
import multi.platform.core.shared.external.utility.ValidationUtil
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Suppress("kotlin:S6305")
class SignInViewModel(
    private val authorizationUseCase: AuthorizationUseCase,
    private val validationUseCase: ValidationUseCase,
    private val signInEmailUseCase: SignInEmailUseCase,
    private val signInProviderUseCase: SignInProviderUseCase,
) : BaseViewModel() {
    val onCheckPhone = MutableStateFlow<Ticket?>(null)
    val signInType = MutableStateFlow<String?>(null)
    val country = MutableStateFlow<String?>(null)
    val phone = MutableStateFlow<String?>(null)
    val phoneError = MutableStateFlow<Int?>(null)
    val email = MutableStateFlow<String?>(null)
    val emailError = MutableStateFlow<Int?>(null)
    val password = MutableStateFlow<String?>(null)
    val passwordError = MutableStateFlow<Int?>(null)
    val signInByGoogleTrigger = MutableStateFlow<Boolean?>(null)
    val signInByFacebookTrigger = MutableStateFlow<Boolean?>(null)

    init {
        signInType.value = "phone"
    }

    fun onGetAccessTokenFail(error: String?) {
        loadingIndicator.value = false
        toastMessage.value = error
    }

    fun goToForgotPassword() {
        toastMessage.value = "Forgot Password Screen"
    }

    fun goToRegister() {
        toastMessage.value = "Register Screen"
    }

    private fun saveTokenLocal(ticket: Ticket?) = scope.launch {
        loadingIndicator.value = false
        onSignedIn.value = ticket
    }

    fun phoneValidate(defaultCountryCode: String?, minCharError: Int, phoneFormatError: Int) {
        val error = when {
            !ValidationUtil.minCharacter(
                8,
                phone.value
            ) && country.value == defaultCountryCode -> minCharError

            !ValidationUtil.phoneFormat(
                country.value,
                phone.value.toString()
            ) -> phoneFormatError

            else -> null
        }
        phoneError.value = error
    }

    fun signInPhone() {
        if (country.value.isNullOrEmpty() || phone.value.isNullOrEmpty() || phoneError.value != null) return
        scope.launch {
            loadingIndicator.value = true
            try {
                val response = authorizationUseCase(country.value + phone.value)
                loadingIndicator.value = false
                onCheckPhone.value = response?.data
            } catch (e: Exception) {
                if (e is ClientRequestException && e.response.status.value in arrayOf(
                        400,
                        401,
                        403
                    )
                ) {
                    validatePhone()
                } else errorMessage.value = e.message.toString()
                loadingIndicator.value = false
            }
        }
    }

    private fun validatePhone() {
        scope.launch {
            try {
                val response = validationUseCase(country.value + phone.value)
                loadingIndicator.value = false
                onCheckPhone.value = response?.data
            } catch (e: Exception) {
                if (e is ClientRequestException && e.response.status.value in arrayOf(
                        400,
                        401,
                        403
                    )
                ) {
                    val meta: Meta? = e.response.body()
                    meta?.let { errorMessage.value = it.message }
                } else errorMessage.value = e.message.toString()
                loadingIndicator.value = false
            }
        }
    }

    fun signInEmail() {
        if (email.value.isNullOrEmpty() || password.value.isNullOrEmpty()) return
        toastMessage.value = "Sign in with email and password" // remove when integration to api
        scope.launch { // uncomment block when integration to api
            loadingIndicator.value = true
            try {
                val response = signInEmailUseCase(email.value.toString(), password.value.toString())
                saveTokenLocal(response?.data)
            } catch (e: Exception) {
                if (e is ClientRequestException && e.response.status.value in arrayOf(
                        400,
                        401,
                        403
                    )
                ) {
                    val meta: Meta? = e.response.body()
                    meta?.let { errorMessage.value = it.message }
                } else errorMessage.value = e.message.toString()
                loadingIndicator.value = false
            }
        }
    }

    fun onGetAccessToken(provider: String, accessToken: String) {
        scope.launch {
            loadingIndicator.value = true
            try {
                val response = signInProviderUseCase(provider, accessToken)
                saveTokenLocal(response?.data)
            } catch (e: Exception) {
                if (e is ClientRequestException && e.response.status.value in arrayOf(
                        400,
                        401,
                        403
                    )
                ) {
                    val meta: Meta? = e.response.body()
                    meta?.let { errorMessage.value = it.message }
                } else errorMessage.value = e.message.toString()
                loadingIndicator.value = false
            }
        }
    }
}