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
class ValidatePhoneUseCaseTest {
    private val authConfig = mockk<AuthConfig>()
    private val authRepository = mockk<AuthRepository>()
    private lateinit var validatePhoneUseCase: ValidatePhoneUseCase

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        validatePhoneUseCase = ValidatePhoneUseCase(authConfig, authRepository)
    }

    @Test
    fun `invoke should call validatePhoneMapper with the result of validatePhone`() = runTest {
        // Arrange
        val phone = "1234567890"
        val validatePhoneResult = mockk<JsonObject>()
        val validatePhoneMappedResult = mockk<Ticket>()

        coEvery { authRepository.validatePhone(phone) } returns validatePhoneResult
        coEvery { authConfig.validatePhoneMapper(validatePhoneResult) } returns validatePhoneMappedResult

        // Act
        val result = validatePhoneUseCase(phone)

        // Assert
        assertEquals(validatePhoneMappedResult, result)
        coEvery { authRepository.validatePhone(phone) }
        coEvery { authConfig.validatePhoneMapper(validatePhoneResult) }
    }
}
