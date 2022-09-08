package tossaro.android.auth.domain.user.usecase

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import tossaro.android.auth.domain.user.UserRepository

class SignInProviderUseCase : KoinComponent {
    private val userRepository: UserRepository by inject()
    suspend operator fun invoke(provider: String, phone: String) =
        userRepository.signInProvider(provider, phone)
}