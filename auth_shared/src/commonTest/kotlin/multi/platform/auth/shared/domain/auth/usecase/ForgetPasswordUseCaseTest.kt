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
class ForgetPasswordUseCaseTest {
    private val authConfig = mockk<AuthConfig>()
    private val authRepository = mockk<AuthRepository>()
    private lateinit var forgetPasswordUseCase: ForgetPasswordUseCase

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        forgetPasswordUseCase = ForgetPasswordUseCase(authConfig, authRepository)
    }

    @Test
    fun `invoke should call forgetPasswordMapper with the result of forgetPassword`() = runTest {
        // Arrange
        val email = "test@example.com"
        val forgetPasswordResult = mockk<JsonObject>()
        val forgetPasswordMappedResult = mockk<Ticket>()

        coEvery { authRepository.forgetPassword(email) } returns forgetPasswordResult
        coEvery { authConfig.forgetPasswordMapper(forgetPasswordResult) } returns forgetPasswordMappedResult

        // Act
        val result = forgetPasswordUseCase(email)

        // Assert
        assertEquals(forgetPasswordMappedResult, result)
        coEvery { authRepository.forgetPassword(email) }
        coEvery { authConfig.forgetPasswordMapper(forgetPasswordResult) }
    }
}
