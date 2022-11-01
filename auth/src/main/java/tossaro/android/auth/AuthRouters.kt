package tossaro.android.auth

object AuthRouters {
    const val HOME = "/home"
    const val REGISTER = "/register/{country}/{phone}"
    const val OTP = "/otp/{type}/{country}/{phone}/{duration}/{ticketId}"
}