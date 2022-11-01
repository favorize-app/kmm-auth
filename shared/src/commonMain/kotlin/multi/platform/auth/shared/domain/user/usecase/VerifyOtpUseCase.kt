package multi.platform.auth.shared.domain.user.usecase

import multi.platform.auth.shared.domain.user.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class VerifyOtpUseCase : KoinComponent {
    private val userRepository: UserRepository by inject()
    suspend operator fun invoke(otp: String, type: String, phone: String) =
        userRepository.verifyOtp(otp, type, phone)
}