package multi.platform.auth.shared.external.config

/**
 * Feature configuration for authentication capabilities.
 * Groups all feature-related configuration in one place.
 */
data class FeatureConfig(
    val socialAuth: SocialAuthConfig,
    val biometric: BiometricConfig,
    val notifications: NotificationConfig
)

/**
 * Social authentication configuration.
 */
data class SocialAuthConfig(
    val facebookAppId: String = "",
    val googleWebClientId: String = ""
)

/**
 * Biometric authentication configuration.
 */
data class BiometricConfig(
    val enabled: Boolean = false
)

/**
 * Notification configuration.
 */
data class NotificationConfig(
    val onesignalAppId: String = ""
)
