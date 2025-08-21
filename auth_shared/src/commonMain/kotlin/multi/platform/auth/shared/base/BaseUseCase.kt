package multi.platform.auth.shared.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import multi.platform.auth.shared.core.StandaloneCore
import multi.platform.auth.shared.external.errors.AuthError

/**
 * Lightweight base UseCase for authentication flows.
 * Provides essential functionality without external dependencies.
 */
abstract class BaseUseCase<in P, R> {
    
    // Coroutine scope for async operations
    protected val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    
    /**
     * Execute the use case with the given parameters.
     * @param params The parameters needed to execute the use case
     * @return The result of the use case execution
     */
    suspend fun execute(params: P): R {
        return try {
            perform(params)
        } catch (e: Exception) {
            val authError = AuthError.fromException(e)
            handleError(authError)
            throw authError
        }
    }
    
    /**
     * Execute the use case asynchronously.
     * @param params The parameters needed to execute the use case
     * @param onSuccess Callback for successful execution
     * @param onError Callback for error handling
     */
    fun executeAsync(
        params: P,
        onSuccess: (R) -> Unit,
        onError: (AuthError) -> Unit
    ) {
        scope.launch {
            try {
                val result = perform(params)
                onSuccess(result)
            } catch (e: Exception) {
                val authError = AuthError.fromException(e)
                handleError(authError)
                onError(authError)
            }
        }
    }
    
    /**
     * Execute the use case with a callback.
     * @param params The parameters needed to execute the use case
     * @param callback Callback for both success and error cases
     */
    fun executeWithCallback(
        params: P,
        callback: (Result<R>) -> Unit
    ) {
        scope.launch {
            try {
                val result = perform(params)
                callback(Result.success(result))
            } catch (e: Exception) {
                val authError = AuthError.fromException(e)
                handleError(authError)
                callback(Result.failure(authError))
            }
        }
    }
    
    /**
     * Perform the actual use case logic.
     * This method must be implemented by subclasses.
     * @param params The parameters needed to execute the use case
     * @return The result of the use case execution
     */
    protected abstract suspend fun perform(params: P): R
    
    /**
     * Handle errors that occur during use case execution.
     * This method can be overridden by subclasses for custom error handling.
     * @param error The authentication error that occurred
     */
    protected open fun handleError(error: AuthError) {
        // Default error handling - can be overridden
        StandaloneCore.logError("UseCase error: ${error.message}", error)
    }
    
    /**
     * Cleanup resources when the use case is no longer needed.
     */
    fun cleanup() {
        scope.launch {
            // Cancel any ongoing operations
            // This can be overridden by subclasses for specific cleanup
        }
    }
}

/**
 * Base UseCase for operations that don't require parameters.
 */
abstract class BaseUseCaseNoParams<R> {
    
    // Coroutine scope for async operations
    protected val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    
    /**
     * Execute the use case.
     * @return The result of the use case execution
     */
    suspend fun execute(): R {
        return try {
            perform()
        } catch (e: Exception) {
            handleError(e)
            throw e
        }
    }
    
    /**
     * Execute the use case asynchronously.
     * @param onSuccess Callback for successful execution
     * @param onError Callback for error handling
     */
    fun executeAsync(
        onSuccess: (R) -> Unit,
        onError: (Exception) -> Unit
    ) {
        scope.launch {
            try {
                val result = perform()
                onSuccess(result)
            } catch (e: Exception) {
                handleError(e)
                onError(e)
            }
        }
    }
    
    /**
     * Execute the use case with a callback.
     * @param callback Callback for both success and error cases
     */
    fun executeWithCallback(callback: (Result<R>) -> Unit) {
        scope.launch {
            try {
                val result = perform()
                callback(Result.success(result))
            } catch (e: Exception) {
                handleError(e)
                callback(Result.failure(e))
            }
        }
    }
    
    /**
     * Perform the actual use case logic.
     * This method must be implemented by subclasses.
     * @return The result of the use case execution
     */
    protected abstract suspend fun perform(): R
    
    /**
     * Handle errors that occur during use case execution.
     * This method can be overridden by subclasses for custom error handling.
     * @param error The exception that occurred
     */
    protected open fun handleError(error: Exception) {
        // Default error handling - can be overridden
        StandaloneCore.logError("UseCase error: ${error.message}", error)
    }
    
    /**
     * Cleanup resources when the use case is no longer needed.
     */
    fun cleanup() {
        scope.launch {
            // Cancel any ongoing operations
            // This can be overridden by subclasses for specific cleanup
        }
    }
}
