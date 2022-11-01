package tossaro.android.auth.domain.user

import com.haroldadmin.cnradapter.NetworkResponse
import tossaro.android.auth.domain.user.entity.User
import tossaro.android.core.data.network.response.ApiResponse
import tossaro.android.core.domain.entity.Ticket
import tossaro.android.core.domain.entity.Token

interface UserRepository {
    suspend fun checkPhone(phone: String): NetworkResponse<ApiResponse<Ticket>, ApiResponse<Void>>
    suspend fun verifyOtpSignIn(otp: Number): NetworkResponse<ApiResponse<Token>, ApiResponse<Void>>
    suspend fun verifyOtpRegister(otp: Number): NetworkResponse<ApiResponse<Ticket>, ApiResponse<Void>>
    suspend fun register(user: User): NetworkResponse<ApiResponse<Token>, ApiResponse<Void>>
    suspend fun signInEmail(
        email: String,
        password: String
    ): NetworkResponse<ApiResponse<Token>, ApiResponse<Void>>

    suspend fun signInProvider(
        provider: String,
        token: String
    ): NetworkResponse<ApiResponse<Token>, ApiResponse<Void>>
}