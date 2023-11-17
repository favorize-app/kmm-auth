package multi.platform.auth.shared.data.auth.network.request

import kotlinx.serialization.Serializable

@Serializable
data class EmailReq(
    val email: String? = null,
)
