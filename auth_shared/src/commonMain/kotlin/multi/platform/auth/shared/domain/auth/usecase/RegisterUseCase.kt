package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.data.auth.network.payload.UserPayload
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.base.BaseUseCase
import multi.platform.auth.shared.domain.auth.entity.Ticket

data class RegisterParams(
    val transactionId: String,
    val userPayload: UserPayload,
    val imageBytes: ByteArray?,
    val imageName: String?
)

class RegisterUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) : BaseUseCase<RegisterParams, Ticket?>() {
    override suspend fun perform(params: RegisterParams): Ticket? {
        return authConfig.registerMapper(
            authRepository.register(
                params.transactionId,
                params.userPayload,
                params.imageBytes,
                params.imageName,
            ),
        )
    }
}
