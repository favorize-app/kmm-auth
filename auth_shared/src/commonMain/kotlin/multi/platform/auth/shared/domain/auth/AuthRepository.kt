package multi.platform.auth.shared.domain.auth

import kotlinx.serialization.json.JsonObject
import multi.platform.auth.shared.data.user.network.request.UserReq
import multi.platform.auth.shared.external.enums.AuthType

interface AuthRepository {
    suspend fun signOut(accessToken: String?): JsonObject? = null

    suspend fun authorization(phone: String): JsonObject? = null
    suspend fun validatePhone(phone: String): JsonObject? = null
    suspend fun verifyOtp(
        otp: String,
        type: String,
        phone: String,
    ): JsonObject? = null

    suspend fun register(
        trxid: String,
        userReq: UserReq,
        imageBytes: ByteArray?,
        imageName: String?,
    ): JsonObject? = null

    suspend fun signInEmail(
        email: String,
        password: String,
    ): JsonObject? = null

    suspend fun signInProvider(
        authType: AuthType,
        token: String,
        userReq: UserReq?,
    ): JsonObject? = null

    suspend fun forgetPassword(email: String): JsonObject? = null
}
