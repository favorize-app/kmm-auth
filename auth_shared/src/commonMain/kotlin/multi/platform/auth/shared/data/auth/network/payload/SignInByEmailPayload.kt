package multi.platform.auth.shared.data.auth.network.payload

import kotlinx.serialization.Serializable

@Serializable
data class SignInByEmailPayload(
    val email: String? = null,
    val password: String? = null,
)
