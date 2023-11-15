package multi.platform.auth.shared.domain.auth.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    var timestamp: Long? = null,
    var state: String? = null,
    var otp: Otp? = null,
    var session: Session? = null,
    @SerialName("transaction_id") var transactionId: String? = null,
)
