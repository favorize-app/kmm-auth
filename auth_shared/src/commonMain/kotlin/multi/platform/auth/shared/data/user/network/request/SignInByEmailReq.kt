package multi.platform.auth.shared.data.user.network.request

import kotlinx.serialization.Serializable

@Serializable
data class SignInByEmailReq(
    val email: String? = null,
    val password: String? = null,
)
