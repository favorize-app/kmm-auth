package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig

class AuthorizationUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(phone: String) =
        authConfig.signInMapper(authRepository.authorization(phone))
}
