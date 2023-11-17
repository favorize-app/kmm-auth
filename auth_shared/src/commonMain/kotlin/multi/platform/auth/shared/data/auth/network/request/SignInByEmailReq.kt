package multi.platform.auth.shared.data.auth.network.request

import kotlinx.serialization.Serializable

@Serializable
data class SignInByEmailReq(
    val email: String? = null,
    val password: String? = null,
)
