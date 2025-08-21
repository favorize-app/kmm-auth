package multi.platform.auth.shared

import multi.platform.auth.shared.external.AuthConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * JavaScript (Web)-specific implementation of the authentication module factory.
 * Uses JS engine for HTTP client optimized for web browsers.
 */
actual fun createAuthModule(authConfig: AuthConfig): AuthModule {
    val httpClient = HttpClient(Js) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        
        // Note: Logging plugin is not available for JS target in this configuration
        // HTTP client will work without logging
    }
    
    return AuthModule(authConfig, httpClient)
}