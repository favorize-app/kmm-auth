package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig

class VerifyOtpUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(otp: String, type: String, phone: String) =
        authConfig.verifyOtpMapper(authRepository.verifyOtp(otp, type, phone))
}
