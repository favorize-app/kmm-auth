package multi.platform.auth.shared.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import multi.platform.auth.shared.utils.ValidationUtils

/**
 * Lightweight base ViewModel for authentication flows.
 * Provides essential functionality without external dependencies.
 */
abstract class BaseViewModel {
    
    // Coroutine scope for async operations
    protected val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    
    // Loading state management
    protected val _loadingIndicator = MutableStateFlow(false)
    val loadingIndicator: MutableStateFlow<Boolean> = _loadingIndicator
    
    // Error handling
    protected val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: MutableStateFlow<String?> = _errorMessage
    
    // Exception handling
    protected val _onException = MutableStateFlow<Exception?>(null)
    val onException: MutableStateFlow<Exception?> = _onException
    
    // Toast message handling
    protected val _toastMessage = MutableStateFlow<String?>(null)
    val toastMessage: MutableStateFlow<String?> = _toastMessage
    
    // Network call configuration
    protected var useAsyncNetworkCall: Boolean = false
    
    // Validation helpers using ValidationUtils
    protected fun validateBlank(
        value: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>,
        fieldName: String = "This field"
    ): Boolean = ValidationUtils.validateBlank(value, error, fieldName)
    
    protected fun validateEmailFormat(
        email: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>
    ): Boolean = ValidationUtils.validateEmailFormat(email, error)
    
    // Utility methods
    protected fun showLoading() {
        _loadingIndicator.value = true
    }
    
    protected fun hideLoading() {
        _loadingIndicator.value = false
    }
    
    protected fun showError(message: String) {
        _errorMessage.value = message
    }
    
    protected fun showToast(message: String) {
        _toastMessage.value = message
    }
    
    protected fun clearErrors() {
        _errorMessage.value = null
        _onException.value = null
    }
    
    // Cleanup
    fun onCleared() {
        scope.launch {
            clearErrors()
            hideLoading()
        }
    }
}
