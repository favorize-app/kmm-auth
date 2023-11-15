package multi.platform.auth.shared.data.user.network.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SigninProviderReq(
    val provider: String? = null,
    val email: String? = null,
    val fullname: String? = null,
    @SerialName("subscriber_access")
    val subscriberAccess: String,
)
