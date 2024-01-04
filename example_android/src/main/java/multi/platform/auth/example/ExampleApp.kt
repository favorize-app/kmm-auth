package multi.platform.auth.example

import android.provider.Settings
import com.onesignal.OneSignal
import com.onesignal.debug.LogLevel
import multi.platform.auth.example.app.profile.ProfileViewModel
import multi.platform.auth.example.data.profile.ProfileRepositoryImpl
import multi.platform.auth.example.domain.profile.ProfileRepository
import multi.platform.auth.example.domain.profile.usecase.GetProfileUseCase
import multi.platform.auth.example.external.AuthConfigImpl
import multi.platform.auth.example.external.CoreConfigImpl
import multi.platform.auth.shared.AuthModule
import multi.platform.core.shared.CoreApplication
import multi.platform.core.shared.external.CoreConfig
import multi.platform.core.shared.external.extensions.toMD5
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.KoinApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class ExampleApp : CoreApplication() {
    override fun sharedPrefsName() = "pri0r_m1cr0_h1ght_4uTh"
    override fun appVersion() = getString(R.string.app_version)

    @Suppress("HardwareIds")
    override fun deviceId() =
        Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            .toString().toMD5()

    override val koinApp: (KoinApplication) -> Unit = { app ->
        app.apply {
            modules(
                module {
                    single<CoreConfig> { CoreConfigImpl() }
                    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
                    singleOf(::GetProfileUseCase)
                    viewModelOf(::ProfileViewModel)
                },
                AuthModule(AuthConfigImpl())(),
            )
        }
    }

    override fun onLaunch() {
        super.onLaunch()
        if (BuildConfig.ONESIGNAL_APP_ID.isNotEmpty()) {
            OneSignal.Debug.logLevel = LogLevel.VERBOSE
            OneSignal.initWithContext(this, BuildConfig.ONESIGNAL_APP_ID)
        }
    }
}
