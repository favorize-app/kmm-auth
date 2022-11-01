package multi.platform.auth.shared.domain.user

import multi.platform.auth.shared.domain.user.entity.User
import multi.platform.core.shared.data.common.network.response.ApiResponse
import multi.platform.core.shared.domain.common.entity.Ticket

interface UserRepository {
    suspend fun authorization(phone: String): ApiResponse<Ticket?>?
    suspend fun validation(phone: String): ApiResponse<Ticket?>?
    suspend fun verifyOtp(
        otp: String,
        type: String,
        phone: String
    ): ApiResponse<Ticket?>?

    suspend fun register(
        trxid: String,
        user: User,
    ): ApiResponse<Ticket?>?

    suspend fun signInEmail(
        email: String,
        password: String
    ): ApiResponse<Ticket?>?

    suspend fun signInProvider(
        provider: String,
        token: String
    ): ApiResponse<Ticket?>?
}