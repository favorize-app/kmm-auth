# KMM Auth Shared - API Reference

This document provides a complete reference for all public APIs in the standalone KMM Auth Shared module.

## 📚 Table of Contents

- [Core Components](#core-components)
- [ViewModels](#viewmodels)
- [Use Cases](#use-cases)
- [Data Classes](#data-classes)
- [Utilities](#utilities)
- [Enums](#enums)
- [Interfaces](#interfaces)

## 🏗️ Core Components

### AuthModule

The main factory class that provides instances of all authentication components.

```kotlin
class AuthModule(
    private val authConfig: AuthConfig,
    private val httpClient: HttpClient
)
```

#### Factory Methods

| Method | Returns | Description |
|--------|---------|-------------|
| `createAuthRepository()` | `AuthRepository` | Creates an authentication repository instance |
| `createAuthorizationUseCase()` | `AuthorizationUseCase` | Creates an authorization use case |
| `createValidatePhoneUseCase()` | `ValidatePhoneUseCase` | Creates a phone validation use case |
| `createVerifyOtpUseCase()` | `VerifyOtpUseCase` | Creates an OTP verification use case |
| `createRegisterUseCase()` | `RegisterUseCase` | Creates a user registration use case |
| `createSignInEmailUseCase()` | `SignInEmailUseCase` | Creates an email sign-in use case |
| `createSignInProviderUseCase()` | `SignInProviderUseCase` | Creates a social provider sign-in use case |
| `createForgetPasswordUseCase()` | `ForgetPasswordUseCase` | Creates a password reset use case |
| `createSignOutUseCase()` | `SignOutUseCase` | Creates a sign-out use case |

### StandaloneCore

Global utilities and configuration for the standalone module.

```kotlin
object StandaloneCore
```

#### Properties

| Property | Type | Description |
|----------|------|-------------|
| `isDebugMode` | `Boolean` | Global debug mode flag |
| `useAsyncNetworkCalls` | `Boolean` | Global async network calls flag |
| `globalLoading` | `StateFlow<Boolean>` | Global loading state |
| `globalError` | `StateFlow<String?>` | Global error state |

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `showGlobalLoading()` | None | `Unit` | Shows global loading indicator |
| `hideGlobalLoading()` | None | `Unit` | Hides global loading indicator |
| `showGlobalError(message: String)` | `message: String` | `Unit` | Shows global error message |
| `clearGlobalError()` | None | `Unit` | Clears global error message |
| `createScope()` | None | `CoroutineScope` | Creates a new coroutine scope |
| `createBackgroundScope()` | None | `CoroutineScope` | Creates a background coroutine scope |
| `log(message: String)` | `message: String` | `Unit` | Logs a message |
| `logError(message: String, throwable: Throwable?)` | `message: String, throwable: Throwable?` | `Unit` | Logs an error |

## 🎯 ViewModels

### BaseViewModel

Base class for all authentication ViewModels with common state management.

```kotlin
abstract class BaseViewModel
```

#### Properties

| Property | Type | Description |
|----------|------|-------------|
| `scope` | `CoroutineScope` | Coroutine scope for async operations |
| `loadingIndicator` | `MutableStateFlow<Boolean>` | Loading state indicator |
| `errorMessage` | `MutableStateFlow<String?>` | Error message state |
| `onException` | `MutableStateFlow<Exception?>` | Exception state |
| `toastMessage` | `MutableStateFlow<String?>` | Toast message state |

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `onCleared()` | None | `Unit` | Cleanup method called when ViewModel is cleared |

#### Protected Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `validateBlank(value, error, fieldName)` | `value: MutableStateFlow<String?>, error: MutableStateFlow<String?>, fieldName: String` | `Boolean` | Validates if a field is not blank |
| `validateEmailFormat(email, error)` | `email: MutableStateFlow<String?>, error: MutableStateFlow<String?>` | `Boolean` | Validates email format |
| `validatePasswordStrength(password, error)` | `password: MutableStateFlow<String?>, error: MutableStateFlow<String?>` | `Boolean` | Validates password strength |
| `validatePasswordMatch(password, confirmPassword, error)` | `password: MutableStateFlow<String?>, confirmPassword: MutableStateFlow<String?>, error: MutableStateFlow<String?>` | `Boolean` | Validates password confirmation |
| `validatePhoneFormat(phone, error)` | `phone: MutableStateFlow<String?>, error: MutableStateFlow<String?>` | `Boolean` | Validates phone number format |
| `validateMinChar(value, error, minChars, fieldName)` | `value: MutableStateFlow<String?>, error: MutableStateFlow<String?>, minChars: Int, fieldName: String` | `Boolean` | Validates minimum character count |

### SignInViewModel

ViewModel for handling user sign-in operations.

```kotlin
class SignInViewModel : BaseViewModel
```

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `authorization(phone: String)` | `phone: String` | `Unit` | Initiates phone authorization |
| `validatePhone(phone: String)` | `phone: String` | `Unit` | Validates phone number |
| `signInEmail(email: String, password: String)` | `email: String, password: String` | `Unit` | Signs in with email and password |
| `signInProvider(authType: AuthType, accessToken: String, userPayload: UserPayload)` | `authType: AuthType, accessToken: String, userPayload: UserPayload` | `Unit` | Signs in with social provider |

### RegisterViewModel

ViewModel for handling user registration operations.

```kotlin
class RegisterViewModel : BaseViewModel
```

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `register(transactionId: String, userPayload: UserPayload, imageBytes: ByteArray?, imageName: String?)` | `transactionId: String, userPayload: UserPayload, imageBytes: ByteArray?, imageName: String?` | `Unit` | Registers a new user |

### OtpViewModel

ViewModel for handling OTP verification operations.

```kotlin
class OtpViewModel : BaseViewModel
```

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `verifyOtp(otp: String, type: String, phone: String)` | `otp: String, type: String, phone: String` | `Unit` | Verifies OTP code |
| `authorization(phone: String)` | `phone: String` | `Unit` | Initiates phone authorization |

### ForgetPasswordViewModel

ViewModel for handling password reset operations.

```kotlin
class ForgetPasswordViewModel : BaseViewModel
```

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `forgetPassword(email: String)` | `email: String` | `Unit` | Initiates password reset process |

### SignOutViewModel

ViewModel for handling user sign-out operations.

```kotlin
class SignOutViewModel : BaseViewModel
```

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `signOut()` | None | `Unit` | Signs out the current user |

## 🔧 Use Cases

### BaseUseCase

Base class for all authentication use cases.

```kotlin
abstract class BaseUseCase<in P, R>
```

#### Generic Parameters

| Parameter | Description |
|-----------|-------------|
| `P` | Input parameter type |
| `R` | Return type |

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `execute(params: P)` | `params: P` | `R` | Executes the use case synchronously |
| `executeAsync(params: P, onSuccess: (R) -> Unit, onError: (Exception) -> Unit)` | `params: P, onSuccess: (R) -> Unit, onError: (Exception) -> Unit` | `Unit` | Executes the use case asynchronously |
| `executeWithCallback(params: P, callback: (Result<R>) -> Unit)` | `params: P, callback: (Result<R>) -> Unit` | `Unit` | Executes the use case with callback |
| `cleanup()` | None | `Unit` | Cleans up resources |

#### Protected Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `perform(params: P)` | `params: P` | `R` | Abstract method to implement the use case logic |
| `handleError(error: Exception)` | `error: Exception` | `Unit` | Handles errors during execution |

### AuthorizationUseCase

Use case for phone number authorization.

```kotlin
class AuthorizationUseCase : BaseUseCase<String, Ticket?>
```

### ValidatePhoneUseCase

Use case for phone number validation.

```kotlin
class ValidatePhoneUseCase : BaseUseCase<String, Ticket?>
```

### VerifyOtpUseCase

Use case for OTP verification.

```kotlin
class VerifyOtpUseCase : BaseUseCase<VerifyOtpParams, Ticket?>
```

### RegisterUseCase

Use case for user registration.

```kotlin
class RegisterUseCase : BaseUseCase<RegisterParams, Ticket?>
```

### SignInEmailUseCase

Use case for email-based sign-in.

```kotlin
class SignInEmailUseCase : BaseUseCase<Pair<String, String>, Ticket?>
```

### SignInProviderUseCase

Use case for social provider sign-in.

```kotlin
class SignInProviderUseCase : BaseUseCase<SignInProviderParams, Ticket?>
```

### ForgetPasswordUseCase

Use case for password reset.

```kotlin
class ForgetPasswordUseCase : BaseUseCase<String, Ticket?>
```

### SignOutUseCase

Use case for user sign-out.

```kotlin
class SignOutUseCase : BaseUseCase<String?, Ticket?>
```

## 📊 Data Classes

### RegisterParams

Parameters for user registration.

```kotlin
data class RegisterParams(
    val transactionId: String,
    val userPayload: UserPayload,
    val imageBytes: ByteArray?,
    val imageName: String?
)
```

### VerifyOtpParams

Parameters for OTP verification.

```kotlin
data class VerifyOtpParams(
    val otp: String,
    val type: String,
    val phoneNumber: String
)
```

### SignInProviderParams

Parameters for social provider sign-in.

```kotlin
data class SignInProviderParams(
    val authType: AuthType,
    val accessToken: String,
    val userPayload: UserPayload
)
```

## 🛠️ Utilities

### ValidationUtils

Utility class for common validation functions.

```kotlin
object ValidationUtils
```

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `validateBlank(value, error, fieldName)` | `value: MutableStateFlow<String?>, error: MutableStateFlow<String?>, fieldName: String` | `Boolean` | Validates if a field is not blank |
| `validateEmailFormat(email, error)` | `email: MutableStateFlow<String?>, error: MutableStateFlow<String?>` | `Boolean` | Validates email format |
| `validatePasswordStrength(password, error)` | `password: MutableStateFlow<String?>, error: MutableStateFlow<String?>` | `Boolean` | Validates password strength |
| `validatePasswordMatch(password, confirmPassword, error)` | `password: MutableStateFlow<String?>, confirmPassword: MutableStateFlow<String?>, error: MutableStateFlow<String?>` | `Boolean` | Validates password confirmation |
| `validatePhoneFormat(phone, error)` | `phone: MutableStateFlow<String?>, error: MutableStateFlow<String?>` | `Boolean` | Validates phone number format |

## 🔤 Enums

### AuthType

Enumeration of supported authentication types.

```kotlin
enum class AuthType
```

#### Values

| Value | Description |
|-------|-------------|
| `GOOGLE` | Google authentication |
| `FACEBOOK` | Facebook authentication |
| `APPLE` | Apple authentication |

## 🔌 Interfaces

### AuthRepository

Interface for authentication data operations.

```kotlin
interface AuthRepository
```

#### Methods

| Method | Parameters | Returns | Description |
|--------|------------|---------|-------------|
| `authorization(phone: String)` | `phone: String` | `JsonObject?` | Initiates phone authorization |
| `validatePhone(phone: String)` | `phone: String` | `JsonObject?` | Validates phone number |
| `verifyOtp(otp: String, type: String, phone: String)` | `otp: String, type: String, phone: String` | `JsonObject?` | Verifies OTP code |
| `register(transactionId: String, userPayload: UserPayload, imageBytes: ByteArray?, imageName: String?)` | `transactionId: String, userPayload: UserPayload, imageBytes: ByteArray?, imageName: String?` | `JsonObject?` | Registers a new user |
| `signInEmail(email: String, password: String)` | `email: String, password: String` | `JsonObject?` | Signs in with email and password |
| `signInProvider(authType: AuthType, accessToken: String, userPayload: UserPayload)` | `authType: AuthType, accessToken: String, userPayload: UserPayload` | `JsonObject?` | Signs in with social provider |
| `forgetPassword(email: String)` | `email: String` | `JsonObject?` | Initiates password reset |
| `signOut(accessToken: String?)` | `accessToken: String?` | `JsonObject?` | Signs out the current user |

## 📱 Platform-Specific Implementations

### Expect/Actual Pattern

The module uses the expect/actual pattern for platform-specific implementations.

#### Expect Declaration

```kotlin
expect fun createAuthModule(authConfig: AuthConfig): AuthModule
```

#### Actual Implementations

| Platform | File Location | HTTP Engine |
|----------|---------------|-------------|
| Android | `src/androidMain/kotlin/.../Actual.kt` | `OkHttp` |
| iOS | `src/iosMain/kotlin/.../Actual.kt` | `Darwin` |
| Desktop | `src/jvmMain/kotlin/.../Actual.kt` | `CIO` |
| Web (JS) | `src/jsMain/kotlin/.../Actual.kt` | `Js` |
| Web (WASM) | `src/wasmJsMain/kotlin/.../Actual.kt` | `Js` |

## 🔒 Dependencies

### Required Dependencies

| Dependency | Purpose |
|------------|---------|
| `kotlinx-coroutines-core` | Coroutines support |
| `kotlinx-serialization-json` | JSON serialization |
| `io.ktor:ktor-client-core` | HTTP client core |
| `io.ktor:ktor-client-content-negotiation` | Content negotiation |
| `io.ktor:ktor-serialization-kotlinx-json` | JSON serialization for Ktor |

### Platform-Specific Dependencies

| Platform | Dependencies |
|----------|--------------|
| Android | `io.ktor:ktor-client-okhttp` |
| iOS | `io.ktor:ktor-client-darwin` |
| Desktop | `io.ktor:ktor-client-cio` |
| Web | `io.ktor:ktor-client-js` |

## 🚀 Migration Guide

### From KMM Core

If you're migrating from a KMM Core-based implementation:

1. **Replace CoreViewModel** → `BaseViewModel`
2. **Replace CoreUseCase** → `BaseUseCase`
3. **Replace Koin DI** → Manual factory pattern with `AuthModule`
4. **Replace ApiClientProvider** → Direct `HttpClient` usage
5. **Update method calls** → Use `execute()` instead of `call()`
6. **Update parameters** → Use data classes instead of varargs

### Breaking Changes

| Old API | New API | Migration |
|---------|---------|-----------|
| `CoreViewModel` | `BaseViewModel` | Change inheritance |
| `CoreUseCase` | `BaseUseCase` | Change inheritance |
| `usecase.call(...)` | `usecase.execute(...)` | Update method calls |
| `Koin.inject()` | `AuthModule.create...()` | Replace DI calls |
| `apiClientProvider.client` | `httpClient` | Direct HTTP client usage |
