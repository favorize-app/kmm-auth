package multi.platform.auth.shared.external

import kotlinx.serialization.json.JsonObject
import multi.platform.auth.shared.domain.auth.entity.Ticket

interface AuthConfig {
    val rootView: Int
    val logo: Int
    val countryFlag: Int
    val headerTransactionIdKey: String

    val host: String
    val signInByPhoneApi: String
    val signInByEmailApi: String
    val signInByProviderApi: String
    fun signInMapper(jsonObject: JsonObject?): Ticket?

    val signOutApi: String
    fun signOutMapper(jsonObject: JsonObject?): Ticket?

    val registerApi: String
    fun registerMapper(jsonObject: JsonObject?): Ticket?

    val verifyOtpApi: String
    fun verifyOtpMapper(jsonObject: JsonObject?): Ticket?

    val forgetPasswordApi: String
    fun forgetPasswordMapper(jsonObject: JsonObject?): Ticket?

    val validatePhoneApi: String
    fun validatePhoneMapper(jsonObject: JsonObject?): Ticket?
}
