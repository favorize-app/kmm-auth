package multi.platform.auth.shared.app.signoutdialog

import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import multi.platform.auth.shared.domain.auth.usecase.SignOutUseCase
import multi.platform.core.shared.app.common.CoreViewModel

@Suppress("KOTLIN:S6305")
class SignOutViewModel(
    private val signOutUseCase: SignOutUseCase,
) : CoreViewModel() {
    val onSignOut = MutableStateFlow(false)
    val onCancel = MutableStateFlow(false)

    fun signOut() {
        var coroutine = scope
        if (useAsyncNetworkCall) coroutine = CoroutineScope(Dispatchers.Default)
        coroutine.launch {
            scope.launch { loadingIndicator.value = true }
            try {
                signOutUseCase.call(accessToken)
                scope.launch {
                    loadingIndicator.value = false
                    onSignOut.value = true
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

    fun cancel() {
        onCancel.value = true
    }
}
