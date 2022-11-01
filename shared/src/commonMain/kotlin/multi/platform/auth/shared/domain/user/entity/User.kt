package multi.platform.auth.shared.domain.user.entity

import androidx.annotation.Keep

@Keep
@Suppress("UNUSED")
data class User(
    val id: Int = 0,
    val fullname: String? = null,
    val bio: String? = null,
    val email: String? = null,
    val country: String? = null,
    val phone: String? = null,
    var picture: String? = null,
)