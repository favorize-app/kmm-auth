package multi.platform.auth.shared

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import multi.platform.auth.shared.app.forgetpassworddialog.ForgetPasswordViewModel
import multi.platform.auth.shared.app.otpdialog.OtpViewModel
import multi.platform.auth.shared.app.register.RegisterViewModel
import multi.platform.auth.shared.app.signin.SignInViewModel
import multi.platform.auth.shared.app.signoutdialog.SignOutViewModel
import multi.platform.auth.shared.data.user.AuthRepositoryImpl
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.domain.auth.usecase.AuthorizationUseCase
import multi.platform.auth.shared.domain.auth.usecase.ForgetPasswordUseCase
import multi.platform.auth.shared.domain.auth.usecase.RegisterUseCase
import multi.platform.auth.shared.domain.auth.usecase.SignInEmailUseCase
import multi.platform.auth.shared.domain.auth.usecase.SignInProviderUseCase
import multi.platform.auth.shared.domain.auth.usecase.SignOutUseCase
import multi.platform.auth.shared.domain.auth.usecase.ValidatePhoneUseCase
import multi.platform.auth.shared.domain.auth.usecase.VerifyOtpUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual fun authModule() = module {
    single<HttpClientEngine> { OkHttp.create() }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }

    singleOf(::AuthorizationUseCase)
    singleOf(::ValidatePhoneUseCase)
    singleOf(::VerifyOtpUseCase)
    singleOf(::RegisterUseCase)
    singleOf(::SignInEmailUseCase)
    singleOf(::SignInProviderUseCase)
    singleOf(::ForgetPasswordUseCase)
    singleOf(::SignOutUseCase)

    viewModelOf(::OtpViewModel)
    viewModelOf(::SignInViewModel)
    viewModelOf(::SignOutViewModel)
    viewModelOf(::RegisterViewModel)
    viewModelOf(::ForgetPasswordViewModel)
}
