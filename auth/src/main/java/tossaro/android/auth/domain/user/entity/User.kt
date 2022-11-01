package tossaro.android.auth.domain.user.entity

data class User(
    val id: Int,
    val name: String?,
    val bio: String?,
    val email: String?,
    val country: String?,
    val phone: String?,
)