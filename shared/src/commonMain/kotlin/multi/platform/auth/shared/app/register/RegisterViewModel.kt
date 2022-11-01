package multi.platform.auth.shared.app.register

import multi.platform.auth.shared.domain.user.entity.User
import multi.platform.auth.shared.domain.user.usecase.RegisterUseCase
import multi.platform.core.shared.app.common.BaseViewModel
import multi.platform.core.shared.domain.common.entity.Meta
import multi.platform.core.shared.domain.common.entity.Ticket
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Suppress("kotlin:S6305")
class RegisterViewModel(
    private val registerUseCase: RegisterUseCase,
) : BaseViewModel() {

    var transactionId = ""
    val name = MutableStateFlow<String?>(null)
    val bio = MutableStateFlow<String?>(null)
    val email = MutableStateFlow<String?>(null)
    val country = MutableStateFlow<String?>(null)
    val phone = MutableStateFlow<String?>(null)
    val picturePath = MutableStateFlow<String?>(null)

    private fun saveTokenLocal(ticket: Ticket?) = scope.launch {
        loadingIndicator.value = false
        onSignedIn.value = ticket
    }

    fun register() {
        val user = User(
            0,
            name.value,
            bio.value,
            email.value,
            country.value,
            phone.value,
            picturePath.value
        )
        scope.launch {
            loadingIndicator.value = true
            try {
                val response = registerUseCase(transactionId, user)
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