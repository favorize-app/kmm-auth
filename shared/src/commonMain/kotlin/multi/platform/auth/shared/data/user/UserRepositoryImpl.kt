package multi.platform.auth.shared.data.user

import multi.platform.auth.shared.data.user.network.request.VerifyOtpReq
import multi.platform.auth.shared.domain.user.UserRepository
import multi.platform.auth.shared.domain.user.entity.User
import multi.platform.core.shared.data.common.network.request.PhoneReq
import multi.platform.core.shared.data.common.network.response.ApiResponse
import multi.platform.core.shared.domain.common.entity.Ticket
import multi.platform.core.shared.external.utility.ApiClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import java.io.File


class UserRepositoryImpl(
    private val apiClient: ApiClient
) : UserRepository {
    override suspend fun authorization(phone: String): ApiResponse<Ticket?>? =
        apiClient.client.post("/api/traveller/v1/authorization") {
            contentType(ContentType.Application.Json)
            setBody(PhoneReq(phone.replace("+", "")))
        }.body()

    override suspend fun validation(phone: String): ApiResponse<Ticket?>? =
        apiClient.client.post("/api/traveller/v1/validation") {
            contentType(ContentType.Application.Json)
            setBody(PhoneReq(phone.replace("+", "")))
        }.body()

    override suspend fun verifyOtp(
        otp: String,
        type: String,
        phone: String
    ): ApiResponse<Ticket?>? =
        apiClient.client.post("/api/traveller/v1/otp") {
            contentType(ContentType.Application.Json)
            setBody(VerifyOtpReq(otp, type, phone.replace("+", "")))
        }.body()

    override suspend fun register(
        trxid: String,
        user: User,
    ): ApiResponse<Ticket?>? =
        apiClient.client.post("/api/traveller/v1/registration") {
            headers { append("x-client-trxid", trxid) }
            setBody(
                MultiPartFormDataContent(
                    formData {
                        user.fullname?.let { append("fullname", it) }
                        user.bio?.let { append("bio", it) }
                        user.email?.let { append("email", it) }
                        user.picture?.let {
                            val file = File(it)
                            append("image", file.readBytes(), Headers.build {
                                append(HttpHeaders.ContentType, "image/png")
                                append(HttpHeaders.ContentDisposition, "filename=\"${file.name}\"")
                            })
                        }
                    }
                )
            )
        }.body()

    override suspend fun signInEmail(email: String, password: String): ApiResponse<Ticket?>? = null

    override suspend fun signInProvider(provider: String, token: String): ApiResponse<Ticket?>? = null
}