package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig

class SignOutUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(accessToken: String?) =
        authConfig.signOutMapper(authRepository.signOut(accessToken))
}
