package tossaro.android.auth.data.user

import tossaro.android.auth.data.user.network.UserServiceV1
import tossaro.android.auth.domain.user.UserRepository
import tossaro.android.auth.domain.user.entity.User

class UserRepositoryImpl(
    private val userServiceV1: UserServiceV1
) : UserRepository {
    override suspend fun checkPhone(phone: String) = userServiceV1.checkPhone(phone)
    override suspend fun verifyOtpSignIn(otp: Number) = userServiceV1.verifyOtpSignIn(otp)
    override suspend fun verifyOtpRegister(otp: Number) = userServiceV1.verifyOtpRegister(otp)
    override suspend fun register(user: User) = userServiceV1.register(user)
    override suspend fun signInEmail(email: String, password: String) =
        userServiceV1.signInEmail(email, password)

    override suspend fun signInProvider(provider: String, token: String) =
        userServiceV1.signInProvider(provider, token)
}