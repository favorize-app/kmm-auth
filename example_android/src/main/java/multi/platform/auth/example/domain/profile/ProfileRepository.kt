package multi.platform.auth.example.domain.profile

import multi.platform.auth.example.data.profile.network.GetProfileResp

@Suppress("kotlin:S6517")
interface ProfileRepository {
    suspend fun getProfile(
        accessToken: String?,
        versionName: String?,
        androidId: String?,
        playerId: String?,
    ): GetProfileResp?
}
