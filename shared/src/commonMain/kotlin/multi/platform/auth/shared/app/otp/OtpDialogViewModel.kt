package multi.platform.auth.shared.app.otp

import multi.platform.auth.shared.domain.user.usecase.AuthorizationUseCase
import multi.platform.auth.shared.domain.user.usecase.VerifyOtpUseCase
import multi.platform.core.shared.app.common.BaseViewModel
import multi.platform.core.shared.domain.common.entity.Meta
import multi.platform.core.shared.domain.common.entity.Ticket
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Suppress("kotlin:S6305")
class OtpDialogViewModel(
    private val authorizationUseCase: AuthorizationUseCase,
    private val verifyOtpUseCase: VerifyOtpUseCase,
) : BaseViewModel() {

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
    val onOTPVerifyRegister = MutableStateFlow<Ticket?>(null)

    fun verifyOtp(otp: String) {
        if (state.value != "null") verifyOtp(otp, tOnboarding)
        else verifyOtp(otp, tLogin)
    }

    private fun saveTokenLocal(ticket: Ticket?) = scope.launch {
        loadingIndicator.value = false
        onSignedIn.value = ticket
    }

    private fun verifyOtp(otp: String, type: String) {
        if (country.value.isNullOrEmpty() && phone.value.isNullOrEmpty()) return
        scope.launch {
            loadingIndicator.value = true
            try {
                val response = verifyOtpUseCase(otp, type, country.value + phone.value)
                if (type == tLogin) saveTokenLocal(response?.data)
                else onOTPVerifyRegister.value = response?.data
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

    fun resendOtp() {
        if (country.value.isNullOrEmpty() && phone.value.isNullOrEmpty()) return
        scope.launch {
            loadingIndicator.value = true
            try {
                authorizationUseCase(country.value + phone.value)
                loadingIndicator.value = false
                otpError.value = ""
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