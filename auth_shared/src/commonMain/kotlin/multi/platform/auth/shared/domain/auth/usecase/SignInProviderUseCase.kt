package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.data.auth.network.payload.UserPayload
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.enums.AuthType
import multi.platform.auth.shared.base.BaseUseCase
import multi.platform.auth.shared.domain.auth.entity.Ticket

data class SignInProviderParams(
    val authType: AuthType,
    val token: String,
    val userPayload: UserPayload?
)

class SignInProviderUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) : BaseUseCase<SignInProviderParams, Ticket?>() {
    override suspend fun perform(params: SignInProviderParams): Ticket? {
        return authConfig.signInMapper(
            authRepository.signInProvider(
                params.authType,
                params.token,
                params.userPayload,
            ),
        )
    }
}
