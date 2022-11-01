package tossaro.android.auth.app.otp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tossaro.android.auth.AuthRouters
import tossaro.android.auth.domain.user.usecase.CheckPhoneUseCase
import tossaro.android.auth.domain.user.usecase.VerifyOtpRegisterUseCase
import tossaro.android.auth.domain.user.usecase.VerifyOtpSignInUseCase
import tossaro.android.core.app.BaseViewModel
import tossaro.android.core.data.network.response.ApiResponse
import tossaro.android.core.domain.entity.Meta
import tossaro.android.core.domain.entity.Ticket
import tossaro.android.core.domain.entity.Token
import tossaro.android.core.external.constant.AppConstant

class OtpDialogViewModel(
    private val checkPhoneUseCase: CheckPhoneUseCase,
    private val verifyOtpSignInUseCase: VerifyOtpSignInUseCase,
    private val verifyOtpRegisterUseCase: VerifyOtpRegisterUseCase,
) : BaseViewModel() {

    val ticketId = MutableLiveData<String>()
    val country = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val type = MutableLiveData<String>()
    val onResendOtp = MutableLiveData<Ticket>()
    val time = MutableLiveData<String?>()
    val otp1 = MutableLiveData<String>()
    val otp2 = MutableLiveData<String>()
    val otp3 = MutableLiveData<String>()
    val otp4 = MutableLiveData<String>()
    val otp5 = MutableLiveData<String>()
    val otp6 = MutableLiveData<String>()
    val otpInfo = MutableLiveData<String>()
    val otpResend = MutableLiveData<String>()
    val onOTPVerifyRegister = MutableLiveData<Ticket>()

    fun verifyOtp(otp: Number) {
        when (type.value) {
            "1" -> verifyOtpSignIn(otp)
            "2" -> verifyOtpRegister(otp)
        }
    }

    private fun saveTokenLocal(apiResponse: ApiResponse<Token>) = viewModelScope.launch {
        sharedPrefs.value?.edit()
            ?.putString(AppConstant.ACCESS_TOKEN, apiResponse.data.token)
            ?.putString(AppConstant.REFRESH_TOKEN, apiResponse.data.refresh_token)
            ?.apply()
        loadingIndicator.value = false
        alertMessage.value = apiResponse.meta.message
        onSignedIn.value = AuthRouters.HOME
    }

    fun verifyOtpSignIn(otp: Number) {
        saveTokenLocal(
            ApiResponse( // remove this block when integration api
                Meta("123", "Welcome back {name}!", null, null),
                Token("token123", "refresh123", "android", 300)
            )
        )
//        viewModelScope.launch { // uncomment block when integration to api
//            loadingIndicator.value = true
//            when (val response = verifyOtpSignInUseCase(otp)) {
//                is NetworkResponse.Success -> {
//                    saveTokenLocal(response.body)
//                }
//                is NetworkResponse.ServerError -> {
//                    loadingIndicator.value = false
//                    otpInfo.value = response.body?.meta?.message
//                    time.value = null
//                }
//                is NetworkResponse.NetworkError -> {
//                    loadingIndicator.value = false
//                    otpInfo.value = response.error.message.orEmpty()
//                    time.value = null
//                }
//            }
//        }
    }

    fun verifyOtpRegister(otp: Number) {
        onOTPVerifyRegister.value =
            Ticket("ticket123", 300, 1) // remove this line when integration to api
//        viewModelScope.launch { // uncomment block when integration to api
//            loadingIndicator.value = true
//            when (val response = verifyOtpRegisterUseCase(otp)) {
//                is NetworkResponse.Success -> {
//                    response.body.data.let { d ->
//                        onOTPVerifyRegister.value = d
//                    }
//                }
//                is NetworkResponse.ServerError -> {
//                    loadingIndicator.value = false
//                    otpInfo.value = response.body?.meta?.message
//                    time.value = null
//                }
//                is NetworkResponse.NetworkError -> {
//                    loadingIndicator.value = false
//                    otpInfo.value = response.error.message.orEmpty()
//                    time.value = null
//                }
//            }
//        }
    }

    fun resendOtp() {
        if (country.value.isNullOrEmpty() && phone.value.isNullOrEmpty()) return
        onResendOtp.value = Ticket("ticketId", 300, 1) // remove this line when integration to api
//        viewModelScope.launch { // uncomment block when integration to api
//            loadingIndicator.value = true
//            when (val response = checkPhoneUseCase(country.value + phone.value)) {
//                is NetworkResponse.Success -> {
//                    response.body.data.let { u ->
//                        onCheckPhone.value = u.token
//                    }
//                }
//                is NetworkResponse.ServerError -> {
//                    loadingIndicator.value = false
//                    alertMessage.value = response.body?.message.orEmpty()
//                }
//                is NetworkResponse.NetworkError -> {
//                    loadingIndicator.value = false
//                    alertMessage.value = response.error.message.orEmpty()
//                }
//            }
//        }
    }
}