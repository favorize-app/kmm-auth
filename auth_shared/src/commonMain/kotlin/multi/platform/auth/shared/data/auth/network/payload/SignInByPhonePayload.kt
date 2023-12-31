package multi.platform.auth.shared.data.auth.network.payload

import kotlinx.serialization.Serializable

@Serializable
data class SignInByPhonePayload(
    val msisdn: String? = null,
)
