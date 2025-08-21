package multi.platform.auth.shared.app.forgetpassworddialog

import io.ktor.client.plugins.ServerResponseException
import kotlinx.io.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import multi.platform.auth.shared.domain.auth.usecase.ForgetPasswordUseCase
import multi.platform.auth.shared.base.BaseViewModel

@Suppress("KOTLIN:S6305")
class ForgetPasswordViewModel(
    private val forgetPasswordUseCase: ForgetPasswordUseCase,
) : BaseViewModel() {

    val email = MutableStateFlow<String?>(null)
    val emailError = MutableStateFlow<String?>(null)
    val onSubmit = MutableStateFlow(false)

    fun submit() {
        if (email.value.isNullOrEmpty() || emailError.value != null) return
        var coroutine = scope
        if (useAsyncNetworkCall) coroutine = CoroutineScope(Dispatchers.Default)
        coroutine.launch {
            scope.launch { loadingIndicator.value = true }
            try {
                forgetPasswordUseCase.execute(email.value!!)
                scope.launch {
                    loadingIndicator.value = false
                    onSubmit.value = true
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
}
