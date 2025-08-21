package multi.platform.auth.shared.external.config

/**
 * Debug configuration for development and logging.
 */
data class DebugConfig(
    val isDebugMode: Boolean = false,
    val enableLogging: Boolean = false,
    val enableNetworkLogging: Boolean = false
)
