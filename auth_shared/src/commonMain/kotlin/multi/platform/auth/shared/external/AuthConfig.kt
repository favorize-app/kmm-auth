package multi.platform.auth.shared.external

import kotlinx.serialization.json.JsonObject
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.config.ApiConfig
import multi.platform.auth.shared.external.config.UiConfig
import multi.platform.auth.shared.external.config.FeatureConfig
import multi.platform.auth.shared.external.config.DebugConfig

/**
 * Main authentication configuration interface.
 * Provides access to all configuration groups.
 */
interface AuthConfig {
    
    // Grouped configurations (new approach)
    val api: ApiConfig
    val ui: UiConfig
    val features: FeatureConfig
    val debug: DebugConfig
    
    // Legacy properties for backward compatibility
    @Deprecated("Use api.endpoints.signInByPhone instead", ReplaceWith("api.endpoints.signInByPhone"))
    val signInByPhoneApi: String get() = api.endpoints.signInByPhone
    
    @Deprecated("Use api.endpoints.signInByEmail instead", ReplaceWith("api.endpoints.signInByEmail"))
    val signInByEmailApi: String get() = api.endpoints.signInByEmail
    
    @Deprecated("Use api.endpoints.signInByProvider instead", ReplaceWith("api.endpoints.signInByProvider"))
    val signInByProviderApi: String get() = api.endpoints.signInByProvider
    
    @Deprecated("Use api.endpoints.signOut instead", ReplaceWith("api.endpoints.signOut"))
    val signOutApi: String get() = api.endpoints.signOut
    
    @Deprecated("Use api.endpoints.register instead", ReplaceWith("api.endpoints.register"))
    val registerApi: String get() = api.endpoints.register
    
    @Deprecated("Use api.endpoints.verifyOtp instead", ReplaceWith("api.endpoints.verifyOtp"))
    val verifyOtpApi: String get() = api.endpoints.verifyOtp
    
    @Deprecated("Use api.endpoints.forgetPassword instead", ReplaceWith("api.endpoints.forgetPassword"))
    val forgetPasswordApi: String get() = api.endpoints.forgetPassword
    
    @Deprecated("Use api.endpoints.validatePhone instead", ReplaceWith("api.endpoints.validatePhone"))
    val validatePhoneApi: String get() = api.endpoints.validatePhone
    
    @Deprecated("Use api.headers.transactionIdKey instead", ReplaceWith("api.headers.transactionIdKey"))
    val headerTransactionIdKey: String get() = api.headers.transactionIdKey
    
    @Deprecated("Use ui.routes.signIn instead", ReplaceWith("ui.routes.signIn"))
    val routeSignIn: String get() = ui.routes.signIn
    
    @Deprecated("Use ui.routes.signOut instead", ReplaceWith("ui.routes.signOut"))
    val routeSignOut: String get() = ui.routes.signOut
    
    @Deprecated("Use ui.routes.register instead", ReplaceWith("ui.routes.register"))
    val routeRegister: String get() = ui.routes.register
    
    @Deprecated("Use ui.routes.otp instead", ReplaceWith("ui.routes.otp"))
    val routeOtp: String get() = ui.routes.otp
    
    @Deprecated("Use ui.routes.forgetPassword instead", ReplaceWith("ui.routes.forgetPassword"))
    val routeForgetPassword: String get() = ui.routes.forgetPassword
    
    @Deprecated("Use ui.routes.errorConnection instead", ReplaceWith("ui.routes.errorConnection"))
    val routeErrorConnection: String get() = ui.routes.errorConnection
    
    @Deprecated("Use features.socialAuth.facebookAppId instead", ReplaceWith("features.socialAuth.facebookAppId"))
    val fbAppId: String get() = features.socialAuth.facebookAppId
    
    @Deprecated("Use features.socialAuth.googleWebClientId instead", ReplaceWith("features.socialAuth.googleWebClientId"))
    val googleWebClientId: String get() = features.socialAuth.googleWebClientId
    
    @Deprecated("Use features.notifications.onesignalAppId instead", ReplaceWith("features.notifications.onesignalAppId"))
    val onesignalAppId: String get() = features.notifications.onesignalAppId
    
    @Deprecated("Use debug.isDebugMode instead", ReplaceWith("debug.isDebugMode"))
    val isDebugMode: Boolean get() = debug.isDebugMode
    
    // Mapper functions (keep as-is for now)
    fun signInMapper(jsonObject: JsonObject?): Ticket?
    fun signOutMapper(jsonObject: JsonObject?): Ticket?
    fun registerMapper(jsonObject: JsonObject?): Ticket?
    fun verifyOtpMapper(jsonObject: JsonObject?): Ticket?
    fun forgetPasswordMapper(jsonObject: JsonObject?): Ticket?
    fun validatePhoneMapper(jsonObject: JsonObject?): Ticket?
}
