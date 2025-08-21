package multi.platform.auth.shared.app.register

import io.ktor.client.plugins.ServerResponseException
import kotlinx.io.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import multi.platform.auth.shared.data.auth.network.payload.UserPayload
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.domain.auth.usecase.RegisterUseCase
import multi.platform.auth.shared.base.BaseViewModel
import multi.platform.auth.shared.utils.ValidationUtils
import multi.platform.auth.shared.domain.auth.usecase.RegisterParams

@Suppress("KOTLIN:S6305")
class RegisterViewModel(
    private val registerUseCase: RegisterUseCase,
) : BaseViewModel() {

    var transactionId = ""
    var errorPasswordConfirm: String? = null
    val name = MutableStateFlow<String?>(null)
    val nameError = MutableStateFlow<String?>(null)
    val bio = MutableStateFlow<String?>(null)
    val bioError = MutableStateFlow<String?>(null)
    val email = MutableStateFlow<String?>(null)
    val emailError = MutableStateFlow<String?>(null)
    val country = MutableStateFlow<String?>(null)
    val phone = MutableStateFlow<String?>(null)
    val phoneError = MutableStateFlow<String?>(null)
    val requirePassword = MutableStateFlow(false)
    val password = MutableStateFlow<String?>(null)
    val passwordError = MutableStateFlow<String?>(null)
    val passwordConfirm = MutableStateFlow<String?>(null)
    val passwordConfirmError = MutableStateFlow<String?>(null)
    val picturePath = MutableStateFlow<String?>(null)
    val onSignedIn = MutableStateFlow<Ticket?>(null)

    private fun saveTokenLocal(ticket: Ticket?) = scope.launch {
        loadingIndicator.value = false
        onSignedIn.value = ticket
    }

    fun register(imageBytes: ByteArray?, imageName: String?) {
        if (validateBlank(name, nameError) || validateBlank(bio, bioError) || validateEmailFormat(
                email,
                emailError,
            )
        ) {
            return
        }
        if (requirePassword.value && (
                validateBlank(password, passwordError) || validateBlank(
                    passwordConfirm,
                    passwordConfirmError,
                ) || validatePassword() == true || validatePasswordConfirm() == true
                )
        ) {
            return
        }
        val userPayload = UserPayload(
            0,
            name.value,
            bio.value,
            email.value,
            country.value,
            phone.value,
            password.value,
        )
        var coroutine = scope
        if (useAsyncNetworkCall) coroutine = CoroutineScope(Dispatchers.Default)
        coroutine.launch {
            scope.launch { loadingIndicator.value = true }
            try {
                val response = registerUseCase.execute(RegisterParams(transactionId, userPayload, imageBytes, imageName))
                saveTokenLocal(response)
            } catch (e: Exception) {
                e.printStackTrace()
                scope.launch {
                    loadingIndicator.value = false
                    when (e) {
                        is ServerResponseException, is IOException -> onException.value = e
                        else -> errorMessage.value = e.message
                    }
                }
            }
        }
    }

    fun validatePassword(): Boolean? {
        if (password.value == null) return null
        return ValidationUtils.validatePasswordStrength(password, passwordError)
    }

    fun validatePasswordConfirm(): Boolean? {
        if (passwordConfirm.value == null) return null
        return ValidationUtils.validatePasswordMatch(password, passwordConfirm, passwordConfirmError)
    }
}
