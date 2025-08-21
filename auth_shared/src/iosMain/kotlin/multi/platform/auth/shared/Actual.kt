package multi.platform.auth.shared

import multi.platform.auth.shared.external.AuthConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * iOS-specific implementation of the authentication module factory.
 * Uses Darwin engine for HTTP client optimized for iOS platforms.
 */
actual fun createAuthModule(authConfig: AuthConfig): AuthModule {
    val httpClient = HttpClient(Darwin) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        
        // Note: Logging plugin is not available for iOS target in this configuration
        // HTTP client will work without logging
    }
    
    return AuthModule(authConfig, httpClient)
}