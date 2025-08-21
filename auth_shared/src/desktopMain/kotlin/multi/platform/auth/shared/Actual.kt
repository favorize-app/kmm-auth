package multi.platform.auth.shared

import multi.platform.auth.shared.external.AuthConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * JVM (Desktop)-specific implementation of the authentication module factory.
 * Uses OkHttp engine for HTTP client optimized for JVM platforms.
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
        
        install(Logging) {
            level = if (authConfig.debug.isDebugMode) LogLevel.ALL else LogLevel.NONE
        }
    }
    
    return AuthModule(authConfig, httpClient)
}
