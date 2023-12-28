package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.data.auth.network.request.UserReq
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.core.shared.domain.common.usecase.CoreUseCase

class RegisterUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) : CoreUseCase {
    override suspend fun call(vararg args: Any?) =
        authConfig.registerMapper(
            authRepository.register(
                args[0] as String,
                args[1] as UserReq,
                args[2] as? ByteArray,
                args[3] as? String,
            ),
        )
}
