package multi.platform.auth.shared.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.Flow

/**
 * Android-specific implementations of common extension functions.
 */

actual fun goTo(destination: String, args: Map<String, String>) {
    // This will be implemented by the consuming app
    // For now, we provide a stub implementation
}

actual fun showToast(message: String) {
    // This will be implemented by the consuming app
    // For now, we provide a stub implementation
}

actual fun showErrorSnackbar(message: String, view: Any?) {
    // This will be implemented by the consuming app
    // For now, we provide a stub implementation
}

/**
 * Android-specific extension functions for Views.
 */
var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

/**
 * Android-specific extension functions for Fragments.
 */
fun Fragment.getString(resId: Int): String {
    return requireContext().getString(resId)
}

fun Fragment.requireContext(): Context {
    return requireContext()
}

fun Fragment.requireActivity(): androidx.activity.ComponentActivity {
    return requireActivity()
}

fun Fragment.findNavController(): androidx.navigation.NavController {
    return findNavController()
}

fun Fragment.setFragmentResult(key: String, result: android.os.Bundle) {
    // This will be implemented by the consuming app
}

fun Fragment.setFragmentResultListener(key: String, callback: (String, android.os.Bundle) -> Unit) {
    // This will be implemented by the consuming app
}

fun Fragment.registerForActivityResult(contract: androidx.activity.result.contract.ActivityResultContract<*, *>, callback: (Any) -> Unit): androidx.activity.result.ActivityResultLauncher<Any> {
    // This will be implemented by the consuming app
    throw NotImplementedError("This should be implemented by the consuming app")
}

fun Fragment.dismiss() {
    // This will be implemented by the consuming app
}

/**
 * Android-specific extension functions for ViewModels.
 */
fun androidx.lifecycle.ViewModel.viewLifecycleOwner(): androidx.lifecycle.LifecycleOwner {
    // This will be implemented by the consuming app
    throw NotImplementedError("This should be implemented by the consuming app")
}

/**
 * Android-specific implementation of launchAndCollectIn for fragments.
 */
fun <T> Flow<T>.launchAndCollectIn(
    fragment: Any,
    action: suspend (T) -> Unit
) {
    // This will be implemented by the consuming app
    // For now, we provide a stub implementation
}

/**
 * Additional extension functions that fragments need.
 */
fun Fragment.showKeyboard() {
    // This will be implemented by the consuming app
}

fun Fragment.getPathFromURI(uri: android.net.Uri): String? {
    // This will be implemented by the consuming app
    return null
}

fun Fragment.accessToken(): String? {
    // This will be implemented by the consuming app
    return null
}

fun Fragment.forceSignout(): Boolean {
    // This will be implemented by the consuming app
    return false
}

fun Fragment.rootView(): android.view.View? {
    // This will be implemented by the consuming app
    return null
}

/**
 * Additional extension functions that fragments need.
 */
fun Fragment.errorMinChar(): String {
    // This will be implemented by the consuming app
    return "error_min_char"
}

fun Fragment.errorPhoneFormat(): String {
    // This will be implemented by the consuming app
    return "error_phone_format"
}

fun Fragment.errorEmptyField(): String {
    // This will be implemented by the consuming app
    return "error_empty_field"
}

fun Fragment.errorEmailFormat(): String {
    // This will be implemented by the consuming app
    return "error_email_format"
}

fun Fragment.errorPasswordFormat(): String {
    // This will be implemented by the consuming app
    return "error_password_format"
}

fun Fragment.countryCode(): String {
    // This will be implemented by the consuming app
    return "country_code"
}

fun Fragment.countryFlag(): String {
    // This will be implemented by the consuming app
    return "country_flag"
}

fun Fragment.logo(): String {
    // This will be implemented by the consuming app
    return "logo"
}

fun Fragment.cR(): String {
    // This will be implemented by the consuming app
    return "cR"
}

/**
 * Additional extension functions that fragments need.
 */
fun Fragment.putString(key: String, value: String) {
    // This will be implemented by the consuming app
}

fun Fragment.resultCode(): Int {
    // This will be implemented by the consuming app
    return 0
}

fun Fragment.data(): android.content.Intent? {
    // This will be implemented by the consuming app
    return null
}

fun Fragment.whenCall(block: () -> Unit) {
    // This will be implemented by the consuming app
    block()
}



