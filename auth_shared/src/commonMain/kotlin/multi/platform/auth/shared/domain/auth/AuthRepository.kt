package multi.platform.auth.shared.domain.auth

import kotlinx.serialization.json.JsonObject
import multi.platform.auth.shared.data.auth.network.payload.UserPayload
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
        userPayload: UserPayload,
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
        userPayload: UserPayload?,
    ): JsonObject?

    suspend fun forgetPassword(email: String): JsonObject?
}
