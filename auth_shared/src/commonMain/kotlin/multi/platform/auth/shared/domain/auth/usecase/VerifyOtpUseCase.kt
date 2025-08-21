package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.base.BaseUseCase
import multi.platform.auth.shared.domain.auth.entity.Ticket

data class VerifyOtpParams(
    val otp: String,
    val type: String,
    val phone: String
)

class VerifyOtpUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) : BaseUseCase<VerifyOtpParams, Ticket?>() {
    override suspend fun perform(params: VerifyOtpParams): Ticket? {
        return authConfig.verifyOtpMapper(
            authRepository.verifyOtp(
                params.otp,
                params.type,
                params.phone,
            ),
        )
    }
}
