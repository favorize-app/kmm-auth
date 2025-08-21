package multi.platform.auth.shared.external.errors

/**
 * Sealed class hierarchy for authentication-related errors.
 * Provides structured error handling across the authentication module.
 */
sealed class AuthError : Exception() {
    
    /**
     * Network-related errors (connection, timeout, etc.)
     */
    data class NetworkError(
        override val message: String,
        val originalError: Throwable? = null
    ) : AuthError()
    
    /**
     * Validation errors for form fields
     */
    data class ValidationError(
        val field: String,
        override val message: String
    ) : AuthError()
    
    /**
     * Authentication errors (invalid credentials, expired tokens, etc.)
     */
    data class AuthenticationError(
        override val message: String,
        val code: String? = null
    ) : AuthError()
    
    /**
     * Server errors (HTTP 5xx, API errors)
     */
    data class ServerError(
        val code: Int,
        override val message: String,
        val details: String? = null
    ) : AuthError()
    
    /**
     * Unknown or unexpected errors
     */
    data class UnknownError(
        override val message: String,
        val originalError: Throwable? = null
    ) : AuthError()
    
    companion object {
        /**
         * Create an appropriate error from an exception
         */
        fun fromException(exception: Throwable): AuthError {
            return when (exception) {
                is AuthError -> exception
                is kotlinx.io.IOException -> NetworkError("Network error", exception)
                else -> UnknownError(exception.message ?: "Unknown error occurred", exception)
            }
        }
    }
}
