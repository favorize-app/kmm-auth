package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig

class SignInEmailUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(email: String, password: String) =
        authConfig.signInMapper(authRepository.signInEmail(email, password))
}
