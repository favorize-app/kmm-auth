package multi.platform.auth.example.external

import multi.platform.core.shared.external.CoreConfig

class CoreConfigImpl(
    override val apiAuthPath: String? = "/login",
    override val apiChannel: String? = "mobile",
    override val apiRefreshTokenPath: String? = "/refresh",
    override val headerChannel: String? = "x-header-channel",
    override val headerDeviceId: String? = "x-header-device-id",
    override val headerLanguage: String? = "x-header-language",
    override val headerOs: String? = "x-header-version",
    override val headerVersion: String? = "x-header-version",
) : CoreConfig
