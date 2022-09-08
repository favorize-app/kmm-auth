package tossaro.android.auth.domain.user.usecase

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tossaro.android.auth.domain.user.UserRepository
import tossaro.android.auth.domain.user.entity.User

class RegisterUseCase : KoinComponent {
    private val userRepository: UserRepository by inject()
    suspend operator fun invoke(user: User) = userRepository.register(user)
}