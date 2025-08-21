package multi.platform.auth.example.domain.profile.entity

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id: Int = 0,
    var fullname: String? = null,
    var email: String? = null,
    var phone: String? = null,
)
