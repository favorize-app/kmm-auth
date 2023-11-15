package multi.platform.auth.shared.data.user.network.request

import kotlinx.serialization.Serializable

@Serializable
data class SignInByPhoneReq(
    val msisdn: String? = null,
)
