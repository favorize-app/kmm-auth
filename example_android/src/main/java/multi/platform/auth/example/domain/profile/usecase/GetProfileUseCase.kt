package multi.platform.auth.example.domain.profile.usecase

import multi.platform.auth.example.domain.profile.ProfileRepository
import multi.platform.core.shared.domain.common.usecase.CoreUseCase

class GetProfileUseCase(
    private val profileRepository: ProfileRepository,
) : CoreUseCase {
    override suspend fun call(vararg args: Any?) =
        profileRepository.getProfile(
            args[0] as? String,
            args[1] as? String,
            args[2] as? String,
            args[3] as? String,
        )
}
