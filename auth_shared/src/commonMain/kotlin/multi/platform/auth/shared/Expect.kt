package multi.platform.auth.shared

import multi.platform.auth.shared.external.AuthConfig

/**
 * Platform-specific authentication module factory.
 * Each platform should implement this to provide platform-specific configuration.
 */
expect fun createAuthModule(authConfig: AuthConfig): AuthModule
