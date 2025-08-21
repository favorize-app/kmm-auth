package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.base.BaseUseCase
import multi.platform.auth.shared.domain.auth.entity.Ticket

class SignInEmailUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) : BaseUseCase<Pair<String, String>, Ticket?>() {
    override suspend fun perform(params: Pair<String, String>): Ticket? {
        return authConfig.signInMapper(authRepository.signInEmail(params.first, params.second))
    }
}
