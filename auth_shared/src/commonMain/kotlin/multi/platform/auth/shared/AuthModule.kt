package multi.platform.auth.shared

import multi.platform.auth.shared.external.AuthConfig
import org.koin.dsl.module

class AuthModule(private val authConfig: AuthConfig) {
    operator fun invoke() = module {
        single<AuthConfig> { authConfig }
        includes(authModule())
    }
}
