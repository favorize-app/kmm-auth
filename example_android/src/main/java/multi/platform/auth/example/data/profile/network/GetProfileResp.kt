package multi.platform.auth.example.data.profile.network

import kotlinx.serialization.Serializable
import multi.platform.auth.example.domain.profile.entity.User

@Serializable
data class GetProfileResp(
    val success: Boolean,
    val message: String,
    val user: User,
)
