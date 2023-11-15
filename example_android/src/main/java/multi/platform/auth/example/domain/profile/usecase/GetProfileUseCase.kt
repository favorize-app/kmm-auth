package multi.platform.auth.example.domain.profile.usecase

import multi.platform.auth.example.domain.profile.ProfileRepository

class GetProfileUseCase(
    private val profileRepository: ProfileRepository,
) {
    suspend operator fun invoke(
        accessToken: String?,
        versionName: String?,
        androidId: String?,
        playerId: String?,
    ) = profileRepository.getProfile(accessToken, versionName, androidId, playerId)
}
