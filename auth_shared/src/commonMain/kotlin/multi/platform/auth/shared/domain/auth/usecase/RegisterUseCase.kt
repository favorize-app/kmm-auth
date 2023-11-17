package multi.platform.auth.shared.domain.auth.usecase

import multi.platform.auth.shared.data.auth.network.request.UserReq
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.external.AuthConfig

class RegisterUseCase(
    private val authConfig: AuthConfig,
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        trxid: String,
        userReq: UserReq,
        imageBytes: ByteArray?,
        imageName: String?,
    ) =
        authConfig.registerMapper(authRepository.register(trxid, userReq, imageBytes, imageName))
}
