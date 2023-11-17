package multi.platform.auth.shared.domain.auth

import kotlinx.serialization.json.JsonObject
import multi.platform.auth.shared.data.auth.network.request.UserReq
import multi.platform.auth.shared.external.enums.AuthType

interface AuthRepository {
    suspend fun signOut(accessToken: String?): JsonObject?

    suspend fun authorization(phone: String): JsonObject?
    suspend fun validatePhone(phone: String): JsonObject?
    suspend fun verifyOtp(
        otp: String,
        type: String,
        phone: String,
    ): JsonObject?

    suspend fun register(
        trxid: String,
        userReq: UserReq,
        imageBytes: ByteArray?,
        imageName: String?,
    ): JsonObject?

    suspend fun signInEmail(
        email: String,
        password: String,
    ): JsonObject?

    suspend fun signInProvider(
        authType: AuthType,
        token: String,
        userReq: UserReq?,
    ): JsonObject?

    suspend fun forgetPassword(email: String): JsonObject?
}
