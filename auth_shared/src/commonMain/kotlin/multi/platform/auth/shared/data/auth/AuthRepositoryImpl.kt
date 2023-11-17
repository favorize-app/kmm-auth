package multi.platform.auth.shared.data.auth

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.delete
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.headers
import io.ktor.client.request.host
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import kotlinx.serialization.json.JsonObject
import multi.platform.auth.shared.data.auth.network.request.EmailReq
import multi.platform.auth.shared.data.auth.network.request.SignInByEmailReq
import multi.platform.auth.shared.data.auth.network.request.SignInByPhoneReq
import multi.platform.auth.shared.data.auth.network.request.SigninProviderReq
import multi.platform.auth.shared.data.auth.network.request.UserReq
import multi.platform.auth.shared.data.auth.network.request.VerifyOtpReq
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.enums.AuthType
import multi.platform.core.shared.external.utilities.network.ApiClientProvider

class AuthRepositoryImpl(
    private val authConfig: AuthConfig,
    private val apiClientProvider: ApiClientProvider<HttpClient>,
) : AuthRepository {
    override suspend fun signOut(accessToken: String?): JsonObject? =
        apiClientProvider.client.delete(authConfig.signOutApi) {
            host = authConfig.host
            accessToken?.let { bearerAuth(it) }
        }.body()

    override suspend fun authorization(phone: String): JsonObject? =
        apiClientProvider.client.post(authConfig.signInByPhoneApi) {
            host = authConfig.host
            contentType(ContentType.Application.Json)
            setBody(SignInByPhoneReq(phone.replace("+", "")))
        }.body()

    override suspend fun validatePhone(phone: String): JsonObject? =
        apiClientProvider.client.post(authConfig.validatePhoneApi) {
            host = authConfig.host
            contentType(ContentType.Application.Json)
            setBody(SignInByPhoneReq(phone.replace("+", "")))
        }.body()

    override suspend fun verifyOtp(
        otp: String,
        type: String,
        phone: String,
    ): JsonObject? =
        apiClientProvider.client.post(authConfig.verifyOtpApi) {
            host = authConfig.host
            contentType(ContentType.Application.Json)
            setBody(VerifyOtpReq(otp, type, phone.replace("+", "")))
        }.body()

    override suspend fun register(
        trxid: String,
        userReq: UserReq,
        imageBytes: ByteArray?,
        imageName: String?,
    ): JsonObject? =
        apiClientProvider.client.post(authConfig.registerApi) {
            host = authConfig.host
            headers { append(authConfig.headerTransactionIdKey, trxid) }
            setBody(
                MultiPartFormDataContent(
                    formData {
                        userReq.fullname?.let { append("fullname", it) }
                        userReq.bio?.let { append("bio", it) }
                        userReq.email?.let { append("email", it) }
                        imageBytes?.let {
                            append(
                                "image",
                                it,
                                Headers.build {
                                    append(HttpHeaders.ContentType, "image/png")
                                    append(
                                        HttpHeaders.ContentDisposition,
                                        "filename=\"$imageName\"",
                                    )
                                },
                            )
                        }
                    },
                ),
            )
        }.body()

    override suspend fun signInEmail(email: String, password: String): JsonObject? =
        apiClientProvider.client.post(authConfig.signInByEmailApi) {
            host = authConfig.host
            contentType(ContentType.Application.Json)
            setBody(SignInByEmailReq(email, password))
        }.body()

    override suspend fun signInProvider(
        authType: AuthType,
        token: String,
        userReq: UserReq?,
    ): JsonObject? =
        apiClientProvider.client.post(authConfig.signInByProviderApi) {
            host = authConfig.host
            contentType(ContentType.Application.Json)
            when (authType) {
                AuthType.GOOGLE, AuthType.FACEBOOK -> setBody(
                    SigninProviderReq(
                        authType.name,
                        userReq?.email,
                        userReq?.fullname,
                        token,
                    ),
                )

                AuthType.BIOMETRIC -> setBody(
                    SigninProviderReq(provider = authType.name, subscriberAccess = token),
                )

                else -> throw Exception("Undefined auth type")
            }
        }.body()

    override suspend fun forgetPassword(email: String): JsonObject? =
        apiClientProvider.client.post(authConfig.forgetPasswordApi) {
            host = authConfig.host
            contentType(ContentType.Application.Json)
            setBody(EmailReq(email))
        }.body()
}
