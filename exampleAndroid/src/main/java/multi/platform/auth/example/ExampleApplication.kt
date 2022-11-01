package multi.platform.auth.example

import android.provider.Settings
import multi.platform.auth.shared.app.otp.OtpDialogViewModel
import multi.platform.auth.shared.app.register.RegisterViewModel
import multi.platform.auth.shared.app.signin.SignInViewModel
import multi.platform.auth.shared.data.user.UserRepositoryImpl
import multi.platform.auth.shared.domain.user.UserRepository
import multi.platform.auth.shared.domain.user.usecase.AuthorizationUseCase
import multi.platform.auth.shared.domain.user.usecase.RegisterUseCase
import multi.platform.auth.shared.domain.user.usecase.SignInEmailUseCase
import multi.platform.auth.shared.domain.user.usecase.SignInProviderUseCase
import multi.platform.auth.shared.domain.user.usecase.ValidationUseCase
import multi.platform.auth.shared.domain.user.usecase.VerifyOtpUseCase
import multi.platform.core.shared.CoreApplication
import multi.platform.core.shared.external.utility.ApiClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class ExampleApplication : CoreApplication() {

    @Suppress("HardwareIds")
    override fun koinModule() = module {
        single {
            ApiClient(
                get(),
                get(),
                sharedPrefsName(),
                BuildConfig.SERVER,
                Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID),
                getString(R.string.app_version),
            )
        }

        single<UserRepository> { UserRepositoryImpl(get()) }

        singleOf(::AuthorizationUseCase)
        singleOf(::ValidationUseCase)
        singleOf(::VerifyOtpUseCase)
        singleOf(::RegisterUseCase)
        singleOf(::SignInEmailUseCase)
        singleOf(::SignInProviderUseCase)

        viewModelOf(::OtpDialogViewModel)
        viewModelOf(::SignInViewModel)
        viewModelOf(::RegisterViewModel)
    }

}