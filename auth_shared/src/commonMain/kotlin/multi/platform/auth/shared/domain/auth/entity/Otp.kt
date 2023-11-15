package multi.platform.auth.shared.domain.auth.entity

import kotlinx.serialization.Serializable

@Serializable
data class Otp(
    var duration: Long? = null,
    var msisdn: String? = null,
)
