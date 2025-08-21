# KMM Auth Shared Module

A standalone authentication module for Kotlin Multiplatform Mobile (KMM) applications that provides comprehensive authentication functionality without external dependencies.

## 🚀 Features

- **Standalone Architecture**: No external dependencies on KMM Core or other heavy libraries
- **Cross-Platform**: Works on Android, iOS, Desktop, and Web
- **Authentication Flows**: Sign in, registration, social authentication, biometric auth
- **Lightweight**: Minimal footprint with only essential dependencies
- **Extensible**: Easy to customize and extend for specific needs

## 🏗️ Architecture

### Core Components

#### BaseViewModel
A lightweight base class that provides essential ViewModel functionality:
- Coroutine scope management
- Loading state management
- Error handling
- Toast message handling
- Basic validation helpers

#### ValidationUtils
A utility class for common validation functions:
- Field validation (blank checks)
- Email format validation
- Password strength validation
- Password matching validation
- Phone number format validation

#### ViewModels
- **SignInViewModel**: Handles user authentication
- **RegisterViewModel**: Manages user registration

### Dependencies

The module only depends on essential libraries:
- **Ktor Client**: For HTTP networking
- **Kotlinx Serialization**: For JSON handling
- **Kotlinx Coroutines**: For async operations

## 📦 Installation

Add the module to your project:

```kotlin
// In your build.gradle.kts
dependencies {
    implementation(project(":auth_shared"))
}
```

## 🎯 Usage

### Basic ViewModel Setup

```kotlin
class MyAuthViewModel : BaseViewModel() {
    
    fun authenticate() {
        showLoading()
        scope.launch {
            try {
                // Your authentication logic here
                hideLoading()
            } catch (e: Exception) {
                hideLoading()
                showError(e.message ?: "Authentication failed")
            }
        }
    }
}
```

### Validation

```kotlin
// Using built-in validation
if (validateBlank(email, emailError, "Email")) return
if (validateEmailFormat(email, emailError)) return

// Using ValidationUtils directly
if (ValidationUtils.validatePasswordStrength(password, passwordError)) return
```

## 🔧 Customization

### Adding Custom Validation

```kotlin
object CustomValidationUtils {
    fun validateCustomField(
        value: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>
    ): Boolean {
        // Your custom validation logic
        return false
    }
}
```

### Extending BaseViewModel

```kotlin
abstract class CustomBaseViewModel : BaseViewModel() {
    
    // Add custom functionality
    protected fun customMethod() {
        // Implementation
    }
}
```

## 🚫 What's NOT Included

- **KMM Core**: Replaced with lightweight BaseViewModel
- **Heavy UI Dependencies**: No Compose or UI framework dependencies
- **Platform-Specific Code**: Pure Kotlin Multiplatform implementation
- **External Authentication Providers**: Basic structure for you to implement

## 📱 Platform Support

- ✅ Android
- ✅ iOS  
- ✅ Desktop (JVM)
- ✅ Web (JavaScript)
- ✅ Web (WASM)

## 🧪 Testing

The module includes test utilities and can be easily tested:

```kotlin
@Test
fun testValidation() {
    val value = MutableStateFlow("")
    val error = MutableStateFlow<String?>(null)
    
    assertTrue(ValidationUtils.validateBlank(value, error))
    assertEquals("This field is required", error.value)
}
```

## 🔄 Migration from KMM Core

If you're migrating from a KMM Core-based implementation:

1. Replace `CoreViewModel` with `BaseViewModel`
2. Update validation calls to use `ValidationUtils`
3. Remove KMM Core dependency from build files
4. Test all authentication flows

## 📈 Performance Benefits

- **Smaller Bundle Size**: No heavy external dependencies
- **Faster Build Times**: Fewer dependencies to resolve
- **Better Control**: Full control over the codebase
- **Easier Maintenance**: No external library updates to manage

## 🤝 Contributing

This module is designed to be easily extensible. Feel free to:
- Add new validation rules
- Extend BaseViewModel functionality
- Add new authentication flows
- Improve error handling

## 🎯 Current Implementation Status

### ✅ Completed
- [x] Removed `kmm-core` dependency from Gradle
- [x] Created `BaseViewModel` to replace `CoreViewModel`
- [x] Created `BaseUseCase` to replace `CoreUseCase`
- [x] Created `ValidationUtils` for common validation functions
- [x] Created `StandaloneCore` for global utilities
- [x] Updated all ViewModels to extend `BaseViewModel`
- [x] Updated all Use Cases to extend `BaseUseCase`
- [x] Replaced Koin dependency injection with manual factory pattern
- [x] Replaced `ApiClientProvider` with direct `HttpClient` usage
- [x] Fixed all compilation errors in common code
- [x] Added platform-specific implementations for `createAuthModule()`
- [x] Fixed deprecated `IOException` imports
- [x] Created comprehensive usage examples (`USAGE_EXAMPLES.md`)
- [x] Created complete API reference (`API_REFERENCE.md`)
- [x] Verified standalone module compilation

### 🔄 In Progress
- [ ] Test Compose Multiplatform example integration
- [ ] Create platform-specific usage guides

### ❌ Not Started (Optional)
- [ ] Platform-specific UI implementations (Android Fragments, iOS Views)
- [ ] Integration testing with real APIs
- [ ] Performance optimization
- [ ] Additional platform support

## 📚 Documentation

- **[Usage Examples](USAGE_EXAMPLES.md)** - Practical examples and best practices
- **[API Reference](API_REFERENCE.md)** - Complete API documentation
- **[Migration Guide](API_REFERENCE.md#migration-guide)** - How to migrate from KMM Core

## 📄 License

MIT License - see LICENSE file for details.
