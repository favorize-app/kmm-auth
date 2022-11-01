package tossaro.android.auth.example

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import tossaro.android.auth.app.otp.OtpDialogViewModel
import tossaro.android.auth.app.register.RegisterViewModel
import tossaro.android.auth.app.signin.SignInViewModel
import tossaro.android.auth.data.user.UserRepositoryImpl
import tossaro.android.auth.data.user.network.UserServiceV1
import tossaro.android.auth.domain.user.UserRepository
import tossaro.android.auth.domain.user.usecase.*
import tossaro.android.core.CoreApplication
import tossaro.android.core.external.utility.NetworkUtil

class ExampleApplication : CoreApplication() {

    override fun koinModule() = module {
        single { NetworkUtil.buildService<UserServiceV1>(BuildConfig.SERVER_V1, get()) }

        singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
        singleOf(::CheckPhoneUseCase)
        singleOf(::VerifyOtpSignInUseCase)
        singleOf(::VerifyOtpRegisterUseCase)
        singleOf(::RegisterUseCase)
        singleOf(::SignInEmailUseCase)
        singleOf(::SignInProviderUseCase)

        viewModelOf(::OtpDialogViewModel)
        viewModelOf(::SignInViewModel)
        viewModelOf(::RegisterViewModel)
    }

}