package multi.platform.auth.shared.domain.user.usecase

import multi.platform.auth.shared.domain.user.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignInEmailUseCase : KoinComponent {
    private val userRepository: UserRepository by inject()
    suspend operator fun invoke(email: String, password: String) =
        userRepository.signInEmail(email, password)
}