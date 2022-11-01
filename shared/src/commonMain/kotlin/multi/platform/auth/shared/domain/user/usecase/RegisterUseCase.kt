package multi.platform.auth.shared.domain.user.usecase

import multi.platform.auth.shared.domain.user.UserRepository
import multi.platform.auth.shared.domain.user.entity.User
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RegisterUseCase : KoinComponent {
    private val userRepository: UserRepository by inject()
    suspend operator fun invoke(trxid: String, user: User) =
        userRepository.register(trxid, user)
}