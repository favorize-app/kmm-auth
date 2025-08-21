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
class SignInEmailUseCaseTest {
    private val authConfig = mockk<AuthConfig>()
    private val authRepository = mockk<AuthRepository>()
    private lateinit var signInEmailUseCase: SignInEmailUseCase

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        signInEmailUseCase = SignInEmailUseCase(authConfig, authRepository)
    }

    @Test
    fun `invoke should call signInMapper with the result of signIn`() = runTest {
        // Arrange
        val email = "test@example.com"
        val password = "password123"
        val signInResult = mockk<JsonObject>()
        val signInMappedResult = mockk<Ticket>()

        coEvery { authRepository.signInEmail(email, password) } returns signInResult
        coEvery { authConfig.signInMapper(signInResult) } returns signInMappedResult

        // Act
        val result = signInEmailUseCase.call(email, password)

        // Assert
        assertEquals(signInMappedResult, result)
        coEvery { authRepository.signInEmail(email, password) }
        coEvery { authConfig.signInMapper(signInResult) }
    }
}
