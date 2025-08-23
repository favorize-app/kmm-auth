package multi.platform.auth.shared.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * Common extension functions for the auth shared module.
 * These provide cross-platform functionality where possible.
 */

/**
 * Launches a coroutine and collects from a Flow in the given scope.
 * This is a common pattern used throughout the auth module.
 */
fun <T> Flow<T>.launchAndCollectIn(
    scope: CoroutineScope,
    action: suspend (T) -> Unit
) {
    scope.launch {
        collect { value ->
            action(value)
        }
    }
}

/**
 * Common keys used for navigation and data passing.
 */
object CommonKey {
    const val EMAIL = "email"
    const val PHONE = "phone"
    const val ACCESS_TOKEN = "access_token"
    const val USER_ID = "user_id"
    const val SIGN_OUT_RESULT = "sign_out_result"
    const val PHONE_KEY = "phone_key"
    const val ACCESS_TOKEN_KEY = "access_token_key"
    const val REFRESH_TOKEN_KEY = "refresh_token_key"
    const val RETRY_KEY = "retry_key"
}

/**
 * Common navigation actions.
 */
expect fun goTo(destination: String, args: Map<String, String> = emptyMap())

/**
 * Common UI actions.
 */
expect fun showToast(message: String)
expect fun showErrorSnackbar(message: String, view: Any? = null)