package multi.platform.auth.example.app.profile

import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import multi.platform.auth.example.domain.profile.entity.User
import multi.platform.auth.example.domain.profile.usecase.GetProfileUseCase
import multi.platform.core.shared.app.common.CoreViewModel

class ProfileViewModel(
    private val getProfileUseCase: GetProfileUseCase,
) : CoreViewModel() {
    private var _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> get() = _user

    fun getProfile(
        versionName: String?,
        androidId: String?,
        playerId: String?,
    ) {
        scope.launch {
            loadingIndicator.value = true
            try {
                val resp = getProfileUseCase(accessToken, versionName, androidId, playerId)
                _user.value = resp?.user
                loadingIndicator.value = false
            } catch (e: Exception) {
                e.printStackTrace()
                loadingIndicator.value = false
                when (e) {
                    is ServerResponseException -> onException.value = e
                    else -> errorMessage.value = e.message
                }
            }
        }
    }

    fun clear() {
        _user.value = null
    }
}
