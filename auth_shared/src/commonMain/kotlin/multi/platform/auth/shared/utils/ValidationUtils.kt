package multi.platform.auth.shared.utils

import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Utility class for common validation functions used across the auth module.
 */
object ValidationUtils {
    
    /**
     * Validates if a field is not blank and sets error message accordingly.
     */
    fun validateBlank(
        value: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>,
        fieldName: String = "This field"
    ): Boolean {
        return if (value.value.isNullOrBlank()) {
            error.value = "$fieldName is required"
            true
        } else {
            error.value = null
            false
        }
    }
    
    /**
     * Validates email format using regex pattern.
     */
    fun validateEmailFormat(
        email: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>
    ): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$")
        return if (email.value?.let { emailRegex.matches(it) } == false) {
            error.value = "Invalid email format"
            true
        } else {
            error.value = null
            false
        }
    }
    
    /**
     * Validates password strength requirements.
     */
    fun validatePasswordStrength(
        password: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>
    ): Boolean {
        val passwordRegex = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}\$")
        return if (password.value?.let { passwordRegex.matches(it) } == false) {
            error.value = "Password must contain at least 8 characters, including uppercase, lowercase, number, and special character"
            true
        } else {
            error.value = null
            false
        }
    }
    
    /**
     * Validates if two password fields match.
     */
    fun validatePasswordMatch(
        password: MutableStateFlow<String?>,
        confirmPassword: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>
    ): Boolean {
        return if (password.value != confirmPassword.value) {
            error.value = "Passwords do not match"
            true
        } else {
            error.value = null
            false
        }
    }
    
    /**
     * Validates phone number format (basic validation).
     */
    fun validatePhoneFormat(
        phone: MutableStateFlow<String?>,
        error: MutableStateFlow<String?>
    ): Boolean {
        val phoneRegex = Regex("^[+]?[0-9]{7,15}\$")
        return if (phone.value?.let { phoneRegex.matches(it) } == false) {
            error.value = "Invalid phone number format"
            true
        } else {
            error.value = null
            false
        }
    }
}
