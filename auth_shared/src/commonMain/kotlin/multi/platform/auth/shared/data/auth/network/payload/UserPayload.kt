package multi.platform.auth.shared.data.auth.network.payload

data class UserPayload(
    val id: Int = 0,
    val fullname: String? = null,
    val bio: String? = null,
    val email: String? = null,
    val country: String? = null,
    val phone: String? = null,
    var picture: String? = null,
    var password: String? = null,
)
