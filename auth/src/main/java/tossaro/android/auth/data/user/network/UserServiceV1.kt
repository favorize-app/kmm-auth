package tossaro.android.auth.data.user.network

import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import tossaro.android.auth.domain.user.entity.User
import tossaro.android.core.data.network.response.ApiResponse
import tossaro.android.core.domain.entity.Ticket
import tossaro.android.core.domain.entity.Token

interface UserServiceV1 {
    @FormUrlEncoded
    @POST("/user/api/sign-in")
    suspend fun checkPhone(
        @Field("phone") phone: String
    ): NetworkResponse<ApiResponse<Ticket>, ApiResponse<Void>>

    @FormUrlEncoded
    @POST("/user/api/v1/verify")
    suspend fun verifyOtpSignIn(
        @Field("otp") otp: Number
    ): NetworkResponse<ApiResponse<Token>, ApiResponse<Void>>

    @FormUrlEncoded
    @POST("/user/api/v1/verify")
    suspend fun verifyOtpRegister(
        @Field("otp") otp: Number
    ): NetworkResponse<ApiResponse<Ticket>, ApiResponse<Void>>

    @FormUrlEncoded
    @POST("/api/user/register")
    suspend fun register(
        @Field("user") user: User
    ): NetworkResponse<ApiResponse<Token>, ApiResponse<Void>>

    @FormUrlEncoded
    @POST("/api/user/signInEmail")
    suspend fun signInEmail(
        @Field("email") email: String,
        @Field("password") password: String
    ): NetworkResponse<ApiResponse<Token>, ApiResponse<Void>>

    @FormUrlEncoded
    @POST("/api/user/signInProvider")
    suspend fun signInProvider(
        @Field("provider") provider: String,
        @Field("token") token: String
    ): NetworkResponse<ApiResponse<Token>, ApiResponse<Void>>
}