package multi.platform.auth.shared.data.auth.network.request

import kotlinx.serialization.Serializable

@Serializable
data class VerifyOtpReq(
    val otp: String? = null,
    val mode: String? = null,
    val msisdn: String? = null,
)
