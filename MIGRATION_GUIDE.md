# 🚀 KMM Auth Migration Guide: From KMM Core to Standalone

## Overview

This guide helps you migrate the KMM Auth module from dependency on [KMM Core](https://gitlab.com/kotlin-multiplatform-mobile/core) to a lightweight, standalone architecture.

## 🎯 Why Migrate?

### **Benefits of Standalone Architecture:**
- ✅ **No External Dependencies**: Self-contained authentication module
- ✅ **Faster Build Times**: Fewer dependencies to resolve
- ✅ **Better Control**: Full control over the codebase
- ✅ **Easier Maintenance**: No external library updates to manage
- ✅ **Smaller Bundle Size**: Reduced APK/IPA size
- ✅ **Platform Flexibility**: Easier to customize for specific needs

### **Current KMM Core Dependencies:**
- `CoreViewModel` - Base ViewModel class
- `CoreUseCase` - Base UseCase class  
- `CoreFragment` - Base Fragment class
- `CoreDialogFragment` - Base DialogFragment class
- `ApiClientProvider` - HTTP client management
- Koin dependency injection modules
- Android-specific utilities and extensions
- Resource management (colors, styles)

## 🔄 Migration Strategy

### **Phase 1: Foundation (Current)**
- ✅ Replace `CoreViewModel` with `BaseViewModel`
- ✅ Create `ValidationUtils` for common validation
- ✅ Create `StandaloneCore` for global utilities
- ✅ Update `SignInViewModel` and `RegisterViewModel`

### **Phase 2: Use Cases (Next)**
- Replace `CoreUseCase` with standalone base classes
- Update all use case implementations
- Maintain existing functionality

### **Phase 3: UI Components (Future)**
- Replace `CoreFragment` with standard Android fragments
- Replace `CoreDialogFragment` with standard dialog fragments
- Update Android-specific implementations

### **Phase 4: Infrastructure (Future)**
- Replace `ApiClientProvider` with direct Ktor client usage
- Replace Koin with manual dependency injection or alternative DI
- Update resource management

## 🛠️ Current Implementation Status

### **✅ Completed:**
```kotlin
// BaseViewModel - Lightweight ViewModel base
abstract class BaseViewModel {
    protected val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    protected val _loadingIndicator = MutableStateFlow(false)
    protected val _errorMessage = MutableStateFlow<String?>(null)
    // ... more functionality
}

// ValidationUtils - Common validation functions
object ValidationUtils {
    fun validateBlank(value: MutableStateFlow<String?>, error: MutableStateFlow<String?>): Boolean
    fun validateEmailFormat(email: MutableStateFlow<String?>, error: MutableStateFlow<String?>): Boolean
    fun validatePasswordStrength(password: MutableStateFlow<String?>, error: MutableStateFlow<String?>): Boolean
    // ... more validation methods
}

// StandaloneCore - Global utilities
object StandaloneCore {
    var isDebugMode: Boolean = false
    fun createScope(): CoroutineScope
    fun log(message: String)
    // ... more utilities
}
```

### **🔄 In Progress:**
- ViewModel migration (SignInViewModel, RegisterViewModel)
- Basic validation utilities

### **⏳ Planned:**
- Use case base classes
- Fragment base classes
- Repository implementations
- Dependency injection
- Resource management

## 📋 Migration Checklist

### **ViewModels:**
- [x] Create `BaseViewModel`
- [x] Update `SignInViewModel`
- [x] Update `RegisterViewModel`
- [ ] Update `ForgetPasswordViewModel`
- [ ] Update `OtpViewModel`
- [ ] Update `SignOutViewModel`

### **Use Cases:**
- [ ] Create `BaseUseCase`
- [ ] Update `AuthorizationUseCase`
- [ ] Update `SignInEmailUseCase`
- [ ] Update `RegisterUseCase`
- [ ] Update `ValidatePhoneUseCase`
- [ ] Update `VerifyOtpUseCase`
- [ ] Update `ForgetPasswordUseCase`
- [ ] Update `SignOutUseCase`

### **UI Components:**
- [ ] Create `BaseFragment`
- [ ] Create `BaseDialogFragment`
- [ ] Update `SignInFragment`
- [ ] Update `SignOutDialogFragment`
- [ ] Update other fragments

### **Infrastructure:**
- [ ] Replace `ApiClientProvider`
- [ ] Update dependency injection
- [ ] Update resource management
- [ ] Update Android extensions

## 🚀 Quick Start Migration

### **1. Update ViewModels:**
```kotlin
// Before (KMM Core)
class SignInViewModel : CoreViewModel()

// After (Standalone)
class SignInViewModel : BaseViewModel()
```

### **2. Update Validation:**
```kotlin
// Before (KMM Core)
if (validateBlank(email, emailError)) return

// After (Standalone)
if (ValidationUtils.validateBlank(email, emailError, "Email")) return
```

### **3. Update Coroutine Scopes:**
```kotlin
// Before (KMM Core)
scope.launch { ... }

// After (Standalone)
scope.launch { ... } // Same API, different implementation
```

## 🔧 Configuration

### **Enable Debug Mode:**
```kotlin
// In your app initialization
StandaloneCore.isDebugMode = BuildConfig.DEBUG
StandaloneCore.useAsyncNetworkCalls = true
```

### **Custom Validation:**
```kotlin
// Add custom validation rules
object CustomValidationUtils {
    fun validateCustomField(
        value: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>
    ): Boolean {
        // Your custom logic
        return false
    }
}
```

## 🧪 Testing

### **Unit Tests:**
```kotlin
@Test
fun testValidation() {
    val value = MutableStateFlow("")
    val error = MutableStateFlow<String?>(null)
    
    assertTrue(ValidationUtils.validateBlank(value, error))
    assertEquals("This field is required", error.value)
}
```

### **Integration Tests:**
```kotlin
@Test
fun testViewModelLifecycle() {
    val viewModel = SignInViewModel()
    
    viewModel.showLoading()
    assertTrue(viewModel.loadingIndicator.value)
    
    viewModel.hideLoading()
    assertFalse(viewModel.loadingIndicator.value)
}
```

## 📚 API Reference

### **BaseViewModel:**
- `scope`: CoroutineScope for async operations
- `loadingIndicator`: StateFlow for loading state
- `errorMessage`: StateFlow for error messages
- `showLoading()`: Show loading indicator
- `hideLoading()`: Hide loading indicator
- `showError(message)`: Show error message

### **ValidationUtils:**
- `validateBlank()`: Check if field is not blank
- `validateEmailFormat()`: Validate email format
- `validatePasswordStrength()`: Check password requirements
- `validatePasswordMatch()`: Verify password confirmation
- `validatePhoneFormat()`: Validate phone number format

### **StandaloneCore:**
- `isDebugMode`: Enable/disable debug logging
- `createScope()`: Create main thread coroutine scope
- `createBackgroundScope()`: Create background coroutine scope
- `log(message)`: Log message (if debug mode enabled)
- `logError(message, throwable)`: Log error with stack trace

## 🚨 Breaking Changes

### **Removed:**
- `CoreViewModel` → Use `BaseViewModel`
- `CoreUseCase` → Will be replaced with `BaseUseCase`
- `CoreFragment` → Will be replaced with `BaseFragment`
- `CoreDialogFragment` → Will be replaced with `BaseDialogFragment`

### **Changed:**
- Validation method signatures (improved with field names)
- Error message format (more descriptive)
- Logging implementation (simplified)

### **New:**
- `ValidationUtils` object for common validation
- `StandaloneCore` for global utilities
- Enhanced error handling and user feedback

## 🤝 Contributing

When contributing to the migration:

1. **Maintain API Compatibility**: Keep existing public APIs working
2. **Add Tests**: Include tests for new functionality
3. **Update Documentation**: Keep this guide current
4. **Follow Patterns**: Use established patterns from completed migrations

## 📞 Support

If you encounter issues during migration:

1. Check the [KMM Auth issues](https://github.com/favorize-app/kmm-auth/issues)
2. Review the [KMM Core documentation](https://gitlab.com/kotlin-multiplatform-mobile/core)
3. Compare with existing migrated components
4. Create a detailed issue report

## 🎉 Success Metrics

Migration is complete when:
- [ ] All ViewModels extend `BaseViewModel`
- [ ] All Use Cases extend `BaseUseCase` (or equivalent)
- [ ] All UI components use standalone base classes
- [ ] No imports reference `multi.platform.core`
- [ ] Build succeeds without KMM Core dependency
- [ ] All tests pass
- [ ] Example apps work correctly

---

**Note**: This migration is designed to be **gradual and non-breaking**. You can migrate components one at a time while maintaining full functionality.
