package multi.platform.auth.shared.app.signin

import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.enums.AuthType

/**
 * Consolidated state for the SignIn screen.
 * Provides a single source of truth for all UI state.
 */
data class SignInState(
    // Form fields
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val country: String = "",
    
    // Validation errors
    val phoneError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    
    // UI state
    val isLoading: Boolean = false,
    val authType: AuthType? = null,
    
    // Results
    val ticket: Ticket? = null,
    val onCheckPhone: Ticket? = null,
    
    // Navigation events
    val onSignedIn: Ticket? = null,
    val onSignInByGoogleClick: Boolean = false,
    val onSignInByFacebookClick: Boolean = false,
    val onSignInByBiometricClick: Boolean = false,
    val onGoToForgetPasswordClick: Boolean = false,
    val onGoToRegisterClick: Boolean = false
) {
    /**
     * Check if the form is valid for phone sign-in
     */
    fun isPhoneValid(): Boolean = 
        phone.isNotBlank() && phoneError == null && country.isNotBlank()
    
    /**
     * Check if the form is valid for email sign-in
     */
    fun isEmailValid(): Boolean = 
        email.isNotBlank() && emailError == null && 
        password.isNotBlank() && passwordError == null
    
    /**
     * Clear all validation errors
     */
    fun clearErrors(): SignInState = copy(
        phoneError = null,
        emailError = null,
        passwordError = null
    )
    
    /**
     * Reset navigation events
     */
    fun resetNavigationEvents(): SignInState = copy(
        onSignInByGoogleClick = false,
        onSignInByFacebookClick = false,
        onSignInByBiometricClick = false,
        onGoToForgetPasswordClick = false,
        onGoToRegisterClick = false
    )
}
