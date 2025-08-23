package multi.platform.auth.shared.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

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