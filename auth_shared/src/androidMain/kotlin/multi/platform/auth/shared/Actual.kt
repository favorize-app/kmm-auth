package multi.platform.auth.shared

import multi.platform.auth.shared.external.AuthConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Android-specific implementation of the authentication module factory.
 * Uses OkHttp engine for HTTP client optimized for Android.
 * Note: Logging plugin is not available for Android target in this configuration
 */
actual fun createAuthModule(authConfig: AuthConfig): AuthModule {
    val httpClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        // Note: Logging plugin is not available for Android target in this configuration
        // HTTP client will work without logging
    }
    
    return AuthModule(authConfig, httpClient)
}
