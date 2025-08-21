package multi.platform.auth.shared.data.auth.network.payload

import kotlinx.serialization.Serializable

@Serializable
data class VerifyOtpPayload(
    val otp: String? = null,
    val mode: String? = null,
    val msisdn: String? = null,
)
