package multi.platform.auth.shared.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Minimal standalone core for KMM Auth module.
 * Provides essential functionality without external dependencies.
 * 
 * This allows for gradual migration from KMM Core while maintaining
 * the existing architecture and functionality.
 */
object StandaloneCore {
    
    // Global configuration
    var isDebugMode: Boolean = false
    var useAsyncNetworkCalls: Boolean = false
    
    // Global state management
    private val _globalLoading = MutableStateFlow(false)
    val globalLoading: StateFlow<Boolean> = _globalLoading
    
    private val _globalError = MutableStateFlow<String?>(null)
    val globalError: StateFlow<String?> = _globalError
    
    // Utility functions
    fun showGlobalLoading() {
        _globalLoading.value = true
    }
    
    fun hideGlobalLoading() {
        _globalLoading.value = false
    }
    
    fun showGlobalError(message: String) {
        _globalError.value = message
    }
    
    fun clearGlobalError() {
        _globalError.value = null
    }
    
    // Coroutine utilities
    fun createScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.Main)
    }
    
    fun createBackgroundScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.Default)
    }
    
    // Logging (simple implementation)
    fun log(message: String) {
        if (isDebugMode) {
            println("[AUTH] $message")
        }
    }
    
    fun logError(message: String, throwable: Throwable? = null) {
        if (isDebugMode) {
            println("[AUTH ERROR] $message")
            throwable?.printStackTrace()
        }
    }
}
