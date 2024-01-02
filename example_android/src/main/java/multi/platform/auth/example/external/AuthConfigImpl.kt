package multi.platform.auth.example.external

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import multi.platform.auth.example.BuildConfig
import multi.platform.auth.example.R
import multi.platform.auth.shared.domain.auth.entity.Session
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.AuthConfig

class AuthConfigImpl(
    override val rootView: Int = R.id.cl_root,
    override val logo: Int = R.mipmap.ic_launcher,
    override val countryFlag: Int = R.drawable.country,
    override val fbAppId: String = BuildConfig.FB_APP_ID,
    override val googleWebClientId: String = BuildConfig.GOOGLE_WEB_CLIENT_ID,
    override val onesignalAppId: String = BuildConfig.ONESIGNAL_APP_ID,
    override val countryCode: String = "+62",

    override val host: String = BuildConfig.AUTH_SERVER,
    override val headerTransactionIdKey: String = "x-header-transaction-id",
    override val signInByEmailApi: String = "/login",
    override val signInByProviderApi: String = "/login/google",
    override val signOutApi: String = "",
    override val registerApi: String = "/register",
    override val forgetPasswordApi: String = "/forget",
    override val signInByPhoneApi: String = "",
    override val validatePhoneApi: String = "",
    override val verifyOtpApi: String = "",
) : AuthConfig {

    private fun check(jsonObject: JsonObject) {
        if (jsonObject["success"]?.jsonPrimitive?.boolean == false) {
            throw Exception(jsonObject["message"]?.jsonPrimitive?.contentOrNull)
        }
    }

    override fun signInMapper(jsonObject: JsonObject?): Ticket? = if (jsonObject != null) {
        check(jsonObject)
        jsonObject["user"]?.jsonObject?.let {
            Ticket(
                session = Session(
                    id = it["id"]?.jsonPrimitive?.contentOrNull,
                    fullname = it["fullname"]?.jsonPrimitive?.contentOrNull,
                    msisdn = it["phone"]?.jsonPrimitive?.contentOrNull,
                    email = it["email"]?.jsonPrimitive?.contentOrNull,
                    token = it["remember_token"]?.jsonPrimitive?.contentOrNull,
                ),
            )
        }
    } else {
        null
    }

    override fun signOutMapper(jsonObject: JsonObject?): Ticket? = if (jsonObject != null) {
        check(jsonObject)
        Ticket()
    } else {
        null
    }

    override fun registerMapper(jsonObject: JsonObject?): Ticket? = if (jsonObject != null) {
        check(jsonObject)
        Ticket()
    } else {
        null
    }

    override fun verifyOtpMapper(jsonObject: JsonObject?): Ticket? = if (jsonObject != null) {
        check(jsonObject)
        Ticket()
    } else {
        null
    }

    override fun forgetPasswordMapper(jsonObject: JsonObject?): Ticket? = if (jsonObject != null) {
        check(jsonObject)
        Ticket()
    } else {
        null
    }

    override fun validatePhoneMapper(jsonObject: JsonObject?): Ticket? = if (jsonObject != null) {
        check(jsonObject)
        Ticket()
    } else {
        null
    }
}
