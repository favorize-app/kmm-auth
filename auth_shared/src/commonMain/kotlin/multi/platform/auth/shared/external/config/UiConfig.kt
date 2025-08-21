package multi.platform.auth.shared.external.config

/**
 * UI configuration for authentication screens.
 * Groups all UI-related configuration in one place.
 */
data class UiConfig(
    val routes: Routes,
    val branding: BrandingConfig
)

/**
 * Navigation routes configuration.
 */
data class Routes(
    val signIn: String,
    val signOut: String,
    val register: String,
    val otp: String,
    val forgetPassword: String,
    val errorConnection: String
)

/**
 * Branding configuration.
 */
data class BrandingConfig(
    val logo: String = "",
    val countryFlag: String = "",
    val countryCode: String = ""
)
