package multi.platform.auth.shared.data.auth.network.payload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SigninProviderPayload(
    val provider: String? = null,
    val email: String? = null,
    val fullname: String? = null,
    @SerialName("subscriber_access")
    val subscriberAccess: String,
)
