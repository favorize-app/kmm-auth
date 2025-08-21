package multi.platform.auth.shared.data.auth

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.delete
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import kotlinx.serialization.json.JsonObject
import multi.platform.auth.shared.data.auth.network.payload.EmailPayload
import multi.platform.auth.shared.data.auth.network.payload.SignInByEmailPayload
import multi.platform.auth.shared.data.auth.network.payload.SignInByPhonePayload
import multi.platform.auth.shared.data.auth.network.payload.SigninProviderPayload
import multi.platform.auth.shared.data.auth.network.payload.UserPayload
import multi.platform.auth.shared.data.auth.network.payload.VerifyOtpPayload
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.enums.AuthType

class AuthRepositoryImpl(
    private val authConfig: AuthConfig,
    private val httpClient: HttpClient,
) : AuthRepository {
    override suspend fun signOut(accessToken: String?): JsonObject? =
        httpClient.delete(authConfig.signOutApi) {
            accessToken?.let { bearerAuth(it) }
        }.body()

    override suspend fun authorization(phone: String): JsonObject? =
        httpClient.post(authConfig.signInByPhoneApi) {
            contentType(ContentType.Application.Json)
            setBody(SignInByPhonePayload(phone.replace("+", "")))
        }.body()

    override suspend fun validatePhone(phone: String): JsonObject? =
        httpClient.post(authConfig.validatePhoneApi) {
            contentType(ContentType.Application.Json)
            setBody(SignInByPhonePayload(phone.replace("+", "")))
        }.body()

    override suspend fun verifyOtp(
        otp: String,
        type: String,
        phone: String,
    ): JsonObject? =
        httpClient.post(authConfig.verifyOtpApi) {
            contentType(ContentType.Application.Json)
            setBody(VerifyOtpPayload(otp, type, phone.replace("+", "")))
        }.body()

    override suspend fun register(
        trxid: String,
        userPayload: UserPayload,
        imageBytes: ByteArray?,
        imageName: String?,
    ): JsonObject? =
        httpClient.post(authConfig.registerApi) {
            headers { append(authConfig.headerTransactionIdKey, trxid) }
            setBody(
                MultiPartFormDataContent(
                    formData {
                        userPayload.fullname?.let { append("fullname", it) }
                        userPayload.bio?.let { append("bio", it) }
                        userPayload.email?.let { append("email", it) }
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
        httpClient.post(authConfig.signInByEmailApi) {
            contentType(ContentType.Application.Json)
            setBody(SignInByEmailPayload(email, password))
        }.body()

    override suspend fun signInProvider(
        authType: AuthType,
        token: String,
        userPayload: UserPayload?,
    ): JsonObject? =
        httpClient.post(authConfig.signInByProviderApi) {
            contentType(ContentType.Application.Json)
            when (authType) {
                AuthType.GOOGLE, AuthType.FACEBOOK -> setBody(
                    SigninProviderPayload(
                        authType.name,
                        userPayload?.email,
                        userPayload?.fullname,
                        token,
                    ),
                )

                AuthType.BIOMETRIC -> setBody(
                    SigninProviderPayload(provider = authType.name, subscriberAccess = token),
                )

                else -> throw Exception("Undefined auth type")
            }
        }.body()

    override suspend fun forgetPassword(email: String): JsonObject? =
        httpClient.post(authConfig.forgetPasswordApi) {
            contentType(ContentType.Application.Json)
            setBody(EmailPayload(email))
        }.body()
}
