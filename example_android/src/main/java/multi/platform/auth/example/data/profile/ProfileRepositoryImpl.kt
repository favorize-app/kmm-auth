package multi.platform.auth.example.data.profile

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import multi.platform.auth.example.data.profile.network.GetProfileResp
import multi.platform.auth.example.domain.profile.ProfileRepository
import multi.platform.core.shared.external.utilities.network.ApiClientProvider

class ProfileRepositoryImpl(
    private val apiClientProvider: ApiClientProvider<HttpClient>,
) : ProfileRepository {
    override suspend fun getProfile(
        accessToken: String?,
        versionName: String?,
        androidId: String?,
        playerId: String?,
    ): GetProfileResp? =
        apiClientProvider.client.get("/profile?token=$accessToken&app_agent=android&app_version=$versionName&device_id=$androidId&player_id=$playerId") {}
            .body()
}
