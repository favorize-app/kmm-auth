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
class AuthorizationUseCaseTest {
    private val authConfig = mockk<AuthConfig>()
    private val authRepository = mockk<AuthRepository>()
    private lateinit var authorizationUseCase: AuthorizationUseCase

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        authorizationUseCase = AuthorizationUseCase(authConfig, authRepository)
    }

    @Test
    fun `invoke should call signInMapper with the result of authorization`() = runTest {
        // Arrange
        val phone = "1234567890"
        val authorizationResult = mockk<JsonObject>()
        val signInResult = mockk<Ticket>()

        coEvery { authRepository.authorization(phone) } returns authorizationResult
        coEvery { authConfig.signInMapper(authorizationResult) } returns signInResult

        // Act
        val result = authorizationUseCase.call(phone)

        // Assert
        assertEquals(signInResult, result)
        coEvery { authRepository.authorization(phone) }
        coEvery { authConfig.signInMapper(authorizationResult) }
    }
}
