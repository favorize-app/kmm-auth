package multi.platform.auth.shared.domain.auth.usecase

import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.serialization.json.JsonObject
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.AuthConfig
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class VerifyOtpUseCaseTest {
    private val authConfig = mockk<AuthConfig>()
    private val authRepository = mockk<AuthRepository>()
    private lateinit var verifyOtpUseCase: VerifyOtpUseCase

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        verifyOtpUseCase = VerifyOtpUseCase(authConfig, authRepository)
    }

    @Test
    fun `invoke should call verifyOtpMapper with the result of verifyOtp`() = runTest {
        // Arrange
        val otp = "123456"
        val type = "email"
        val phone = "1234567890"
        val verifyOtpResult = mockk<JsonObject>()
        val verifyOtpMappedResult = mockk<Ticket>()

        coEvery { authRepository.verifyOtp(otp, type, phone) } returns verifyOtpResult
        coEvery { authConfig.verifyOtpMapper(verifyOtpResult) } returns verifyOtpMappedResult

        // Act
        val result = verifyOtpUseCase(otp, type, phone)

        // Assert
        assertEquals(verifyOtpMappedResult, result)
        coEvery { authRepository.verifyOtp(otp, type, phone) }
        coEvery { authConfig.verifyOtpMapper(verifyOtpResult) }
    }
}
