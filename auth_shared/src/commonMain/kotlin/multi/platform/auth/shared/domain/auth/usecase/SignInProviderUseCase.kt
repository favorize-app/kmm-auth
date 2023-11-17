package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.data.auth.network.request.UserReq
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.enums.AuthType

class SignInProviderUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(authType: AuthType, token: String, userReq: UserReq?) =
        authConfig.signInMapper(authRepository.signInProvider(authType, token, userReq))
}
