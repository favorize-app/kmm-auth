# KMM Auth Shared - Usage Examples

This document provides practical examples of how to use the standalone KMM Auth Shared module.

## 🚀 Quick Start

### 1. Basic Setup

```kotlin
// Create an AuthConfig instance
val authConfig = AuthConfig(
    baseUrl = "https://your-api.com",
    isDebugMode = true
)

// Create an HTTP client (platform-specific)
val httpClient = HttpClient(OkHttp) // Android
// val httpClient = HttpClient(Darwin) // iOS
// val httpClient = HttpClient(CIO) // Desktop
// val httpClient = HttpClient(Js) // Web

// Create the auth module
val authModule = createAuthModule(authConfig)

// Get the components you need
val authRepository = authModule.createAuthRepository()
val signInUseCase = authModule.createSignInEmailUseCase()
```

### 2. Sign In with Email

```kotlin
class SignInViewModel : BaseViewModel() {
    private val signInUseCase = authModule.createSignInEmailUseCase()
    
    fun signIn(email: String, password: String) {
        scope.launch {
            try {
                _loadingIndicator.value = true
                val result = signInUseCase.execute(Pair(email, password))
                
                if (result != null) {
                    // Success - handle the ticket
                    _toastMessage.value = "Sign in successful!"
                } else {
                    _errorMessage.value = "Invalid credentials"
                }
            } catch (e: Exception) {
                _onException.value = e
            } finally {
                _loadingIndicator.value = false
            }
        }
    }
}
```

### 3. Phone Number Validation

```kotlin
class PhoneValidationViewModel : BaseViewModel() {
    private val validatePhoneUseCase = authModule.createValidatePhoneUseCase()
    
    fun validatePhone(phoneNumber: String) {
        scope.launch {
            try {
                _loadingIndicator.value = true
                val result = validatePhoneUseCase.execute(phoneNumber)
                
                if (result != null) {
                    // Phone is valid, proceed to OTP
                    _toastMessage.value = "Phone number validated!"
                } else {
                    _errorMessage.value = "Invalid phone number"
                }
            } catch (e: Exception) {
                _onException.value = e
            } finally {
                _loadingIndicator.value = false
            }
        }
    }
}
```

### 4. User Registration

```kotlin
class RegistrationViewModel : BaseViewModel() {
    private val registerUseCase = authModule.createRegisterUseCase()
    
    fun register(
        transactionId: String,
        userPayload: UserPayload,
        imageBytes: ByteArray?,
        imageName: String?
    ) {
        scope.launch {
            try {
                _loadingIndicator.value = true
                val params = RegisterParams(transactionId, userPayload, imageBytes, imageName)
                val result = registerUseCase.execute(params)
                
                if (result != null) {
                    _toastMessage.value = "Registration successful!"
                } else {
                    _errorMessage.value = "Registration failed"
                }
            } catch (e: Exception) {
                _onException.value = e
            } finally {
                _loadingIndicator.value = false
            }
        }
    }
}
```

### 5. OTP Verification

```kotlin
class OtpViewModel : BaseViewModel() {
    private val verifyOtpUseCase = authModule.createVerifyOtpUseCase()
    
    fun verifyOtp(otp: String, type: String, phoneNumber: String) {
        scope.launch {
            try {
                _loadingIndicator.value = true
                val params = VerifyOtpParams(otp, type, phoneNumber)
                val result = verifyOtpUseCase.execute(params)
                
                if (result != null) {
                    _toastMessage.value = "OTP verified successfully!"
                } else {
                    _errorMessage.value = "Invalid OTP"
                }
            } catch (e: Exception) {
                _onException.value = e
            } finally {
                _loadingIndicator.value = false
            }
        }
    }
}
```

### 6. Social Sign In

```kotlin
class SocialSignInViewModel : BaseViewModel() {
    private val signInProviderUseCase = authModule.createSignInProviderUseCase()
    
    fun signInWithProvider(
        authType: AuthType,
        accessToken: String,
        userPayload: UserPayload
    ) {
        scope.launch {
            try {
                _loadingIndicator.value = true
                val params = SignInProviderParams(authType, accessToken, userPayload)
                val result = signInProviderUseCase.execute(params)
                
                if (result != null) {
                    _toastMessage.value = "Social sign in successful!"
                } else {
                    _errorMessage.value = "Social sign in failed"
                }
            } catch (e: Exception) {
                _onException.value = e
            } finally {
                _loadingIndicator.value = false
            }
        }
    }
}
```

### 7. Password Reset

```kotlin
class PasswordResetViewModel : BaseViewModel() {
    private val forgetPasswordUseCase = authModule.createForgetPasswordUseCase()
    
    fun resetPassword(email: String) {
        scope.launch {
            try {
                _loadingIndicator.value = true
                val result = forgetPasswordUseCase.execute(email)
                
                if (result != null) {
                    _toastMessage.value = "Password reset email sent!"
                } else {
                    _errorMessage.value = "Failed to send reset email"
                }
            } catch (e: Exception) {
                _onException.value = e
            } finally {
                _loadingIndicator.value = false
            }
        }
    }
}
```

### 8. Sign Out

```kotlin
class SignOutViewModel : BaseViewModel() {
    private val signOutUseCase = authModule.createSignOutUseCase()
    
    fun signOut(accessToken: String?) {
        scope.launch {
            try {
                _loadingIndicator.value = true
                val result = signOutUseCase.execute(accessToken)
                
                if (result != null) {
                    _toastMessage.value = "Signed out successfully!"
                } else {
                    _errorMessage.value = "Sign out failed"
                }
            } catch (e: Exception) {
                _onException.value = e
            } finally {
                _loadingIndicator.value = false
            }
        }
    }
}
```

## 🔧 Platform-Specific Setup

### Android

```kotlin
// In your Android module
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
            level = if (authConfig.isDebugMode) LogLevel.ALL else LogLevel.NONE
        }
    }
    
    return AuthModule(authConfig, httpClient)
}
```

### iOS

```kotlin
// In your iOS module
actual fun createAuthModule(authConfig: AuthConfig): AuthModule {
    val httpClient = HttpClient(Darwin) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        
        install(Logging) {
            level = if (authConfig.isDebugMode) LogLevel.ALL else LogLevel.NONE
        }
    }
    
    return AuthModule(authConfig, httpClient)
}
```

### Desktop

```kotlin
// In your Desktop module
actual fun createAuthModule(authConfig: AuthConfig): AuthModule {
    val httpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        
        install(Logging) {
            level = if (authConfig.isDebugMode) LogLevel.ALL else LogLevel.NONE
        }
    }
    
    return AuthModule(authConfig, httpClient)
}
```

### Web

```kotlin
// In your Web module
actual fun createAuthModule(authConfig: AuthConfig): AuthModule {
    val httpClient = HttpClient(Js) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        
        install(Logging) {
            level = if (authConfig.isDebugMode) LogLevel.ALL else LogLevel.NONE
        }
    }
    
    return AuthModule(authConfig, httpClient)
}
```

## 📱 State Management

### Using StateFlow in Compose

```kotlin
@Composable
fun SignInScreen(viewModel: SignInViewModel) {
    val loading by viewModel.loadingIndicator.collectAsState()
    val error by viewModel.errorMessage.collectAsState()
    val toast by viewModel.toastMessage.collectAsState()
    
    LaunchedEffect(toast) {
        toast?.let { message ->
            // Show toast
            viewModel.toastMessage.value = null
        }
    }
    
    LaunchedEffect(error) {
        error?.let { errorMessage ->
            // Show error
            viewModel.errorMessage.value = null
        }
    }
    
    Column {
        if (loading) {
            CircularProgressIndicator()
        }
        
        // Your UI components
        Button(
            onClick = { viewModel.signIn("email@example.com", "password") }
        ) {
            Text("Sign In")
        }
    }
}
```

## 🎯 Best Practices

1. **Error Handling**: Always wrap use case calls in try-catch blocks
2. **Loading States**: Use the built-in loading indicators for better UX
3. **State Management**: Leverage StateFlow for reactive UI updates
4. **Resource Cleanup**: Call `cleanup()` on use cases when done
5. **Validation**: Use the built-in validation utilities
6. **Platform Independence**: Keep platform-specific code minimal

## 🔍 Troubleshooting

### Common Issues

1. **HTTP Client Issues**: Ensure you're using the correct engine for your platform
2. **Serialization Errors**: Check that your data classes match the API response
3. **Network Errors**: Verify your base URL and network permissions
4. **Platform Compatibility**: Ensure you've implemented the `expect` function for your platform

### Debug Mode

Enable debug mode in your `AuthConfig` to get detailed logging:

```kotlin
val authConfig = AuthConfig(
    baseUrl = "https://your-api.com",
    isDebugMode = true // Enable detailed logging
)
```
