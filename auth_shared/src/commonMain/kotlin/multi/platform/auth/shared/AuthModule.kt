package multi.platform.auth.shared

import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.data.auth.AuthRepositoryImpl
import multi.platform.auth.shared.domain.auth.usecase.*
import io.ktor.client.HttpClient

/**
 * Standalone authentication module factory.
 * Provides instances of all authentication components without external dependencies.
 */
class AuthModule(
    private val authConfig: AuthConfig,
    private val httpClient: HttpClient
) {
    
    /**
     * Create an instance of AuthRepository
     */
    fun createAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(authConfig, httpClient)
    }
    
    /**
     * Create an instance of AuthorizationUseCase
     */
    fun createAuthorizationUseCase(): AuthorizationUseCase {
        return AuthorizationUseCase(authConfig, createAuthRepository())
    }
    
    /**
     * Create an instance of SignInEmailUseCase
     */
    fun createSignInEmailUseCase(): SignInEmailUseCase {
        return SignInEmailUseCase(authConfig, createAuthRepository())
    }
    
    /**
     * Create an instance of RegisterUseCase
     */
    fun createRegisterUseCase(): RegisterUseCase {
        return RegisterUseCase(authConfig, createAuthRepository())
    }
    
    /**
     * Create an instance of ValidatePhoneUseCase
     */
    fun createValidatePhoneUseCase(): ValidatePhoneUseCase {
        return ValidatePhoneUseCase(authConfig, createAuthRepository())
    }
    
    /**
     * Create an instance of VerifyOtpUseCase
     */
    fun createVerifyOtpUseCase(): VerifyOtpUseCase {
        return VerifyOtpUseCase(authConfig, createAuthRepository())
    }
    
    /**
     * Create an instance of ForgetPasswordUseCase
     */
    fun createForgetPasswordUseCase(): ForgetPasswordUseCase {
        return ForgetPasswordUseCase(authConfig, createAuthRepository())
    }
    
    /**
     * Create an instance of SignOutUseCase
     */
    fun createSignOutUseCase(): SignOutUseCase {
        return SignOutUseCase(authConfig, createAuthRepository())
    }
    
    /**
     * Create an instance of SignInProviderUseCase
     */
    fun createSignInProviderUseCase(): SignInProviderUseCase {
        return SignInProviderUseCase(authConfig, createAuthRepository())
    }
}
