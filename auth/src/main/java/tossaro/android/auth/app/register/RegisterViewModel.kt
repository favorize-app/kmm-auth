package tossaro.android.auth.app.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tossaro.android.auth.AuthRouters
import tossaro.android.auth.domain.user.entity.User
import tossaro.android.core.app.BaseViewModel
import tossaro.android.core.data.network.response.ApiResponse
import tossaro.android.core.domain.entity.Meta
import tossaro.android.core.domain.entity.Token
import tossaro.android.core.external.constant.AppConstant

class RegisterViewModel : BaseViewModel() {

    val name = MutableLiveData<String>()
    val bio = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val country = MutableLiveData<String>()
    val phone = MutableLiveData<String>()

    private fun saveTokenLocal(apiResponse: ApiResponse<Token>) = viewModelScope.launch {
        sharedPrefs.value?.edit()
            ?.putString(AppConstant.ACCESS_TOKEN, apiResponse.data.token)
            ?.putString(AppConstant.REFRESH_TOKEN, apiResponse.data.refresh_token)
            ?.apply()
        loadingIndicator.value = false
        alertMessage.value = apiResponse.meta.message
        onSignedIn.value = AuthRouters.HOME
    }

    fun register() {
        val user = User(0, name.value, bio.value, email.value, country.value, phone.value)
        saveTokenLocal(
            ApiResponse( // remove this block when integration api
                Meta("123", "Welcome back ${user.name}!", null, null),
                Token("token123", "refresh123", "android", 300)
            )
        )
    }

}