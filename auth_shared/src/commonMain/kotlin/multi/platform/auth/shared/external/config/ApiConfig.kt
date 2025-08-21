package multi.platform.auth.shared.external.config

/**
 * API configuration for authentication endpoints.
 * Groups all API-related configuration in one place.
 */
data class ApiConfig(
    val baseUrl: String = "",
    val endpoints: Endpoints,
    val headers: Headers
)

/**
 * API endpoints configuration.
 */
data class Endpoints(
    val signInByPhone: String,
    val signInByEmail: String,
    val signInByProvider: String,
    val signOut: String,
    val register: String,
    val verifyOtp: String,
    val forgetPassword: String,
    val validatePhone: String
)

/**
 * API headers configuration.
 */
data class Headers(
    val transactionIdKey: String
)
