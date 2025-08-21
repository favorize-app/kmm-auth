package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.core.shared.domain.common.usecase.CoreUseCase

class VerifyOtpUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) : CoreUseCase {
    override suspend fun call(vararg args: Any?) =
        authConfig.verifyOtpMapper(
            authRepository.verifyOtp(
                args[0] as String,
                args[1] as String,
                args[2] as String,
            ),
        )
}
