package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.base.BaseUseCase
import multi.platform.auth.shared.domain.auth.entity.Ticket

class AuthorizationUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) : BaseUseCase<String, Ticket?>() {
    override suspend fun perform(params: String): Ticket? {
        return authConfig.signInMapper(authRepository.authorization(params))
    }
}
