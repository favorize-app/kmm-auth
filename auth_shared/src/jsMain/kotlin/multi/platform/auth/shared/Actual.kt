package multi.platform.auth.shared

import org.koin.core.module.Module

actual fun authModule(): Module = webAuthModule()

/**
 * Web-compatible authentication module for JavaScript platform
 * Provides HTTP-based authentication without mobile-specific dependencies
 */
fun webAuthModule(): Module = org.koin.core.module.Module("WebAuth") {
    // Web-specific implementations will be added here
    // For now, this provides a placeholder for web authentication
}
