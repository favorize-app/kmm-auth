package multi.platform.auth.shared.app.otpdialog

import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.domain.auth.usecase.AuthorizationUseCase
import multi.platform.auth.shared.domain.auth.usecase.VerifyOtpUseCase
import multi.platform.core.shared.app.common.CoreViewModel

@Suppress("KOTLIN:S6305")
class OtpViewModel(
    private val authorizationUseCase: AuthorizationUseCase,
    private val verifyOtpUseCase: VerifyOtpUseCase,
) : CoreViewModel() {

    private val tLogin = "LOGIN"
    private val tOnboarding = "ONBOARDING"
    val transactionId = MutableStateFlow<String?>(null)
    val country = MutableStateFlow<String?>(null)
    val phone = MutableStateFlow<String?>(null)
    val state = MutableStateFlow<String?>(null)
    val onResendOtp = MutableStateFlow<Ticket?>(null)
    val time = MutableStateFlow<String?>(null)
    val otp1 = MutableStateFlow<String?>(null)
    val otp2 = MutableStateFlow<String?>(null)
    val otp3 = MutableStateFlow<String?>(null)
    val otp4 = MutableStateFlow<String?>(null)
    val otp5 = MutableStateFlow<String?>(null)
    val otp6 = MutableStateFlow<String?>(null)
    val otpError = MutableStateFlow<String?>(null)
    val otpResend = MutableStateFlow<String?>(null)
    val onSignedIn = MutableStateFlow<Ticket?>(null)
    val onOTPVerifyRegister = MutableStateFlow<Ticket?>(null)

    fun verifyOtp(otp: String) {
        if (state.value != "null") {
            verifyOtp(otp, tOnboarding)
        } else {
            verifyOtp(otp, tLogin)
        }
    }

    private fun saveTokenLocal(ticket: Ticket?) = scope.launch {
        loadingIndicator.value = false
        onSignedIn.value = ticket
    }

    private fun verifyOtp(otp: String, type: String) {
        if (country.value.isNullOrEmpty() && phone.value.isNullOrEmpty()) return
        var coroutine = scope
        if (useAsyncNetworkCall) coroutine = CoroutineScope(Dispatchers.Default)
        coroutine.launch {
            scope.launch { loadingIndicator.value = true }
            try {
                val response = verifyOtpUseCase(otp, type, country.value + phone.value)
                if (type == tLogin) {
                    saveTokenLocal(response)
                } else {
                    scope.launch { onOTPVerifyRegister.value = response }
                }
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

    fun resendOtp() {
        if (country.value.isNullOrEmpty() && phone.value.isNullOrEmpty()) return
        scope.launch {
            loadingIndicator.value = true
            try {
                val response = authorizationUseCase(country.value + phone.value)
                loadingIndicator.value = false
                otpError.value = ""
                onResendOtp.value = response
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
}
