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
import multi.platform.auth.shared.data.user.network.request.UserReq
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.AuthConfig
import multi.platform.auth.shared.external.enums.AuthType
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class SignInProviderUseCaseTest {
    private val authConfig = mockk<AuthConfig>()
    private val authRepository = mockk<AuthRepository>()
    private lateinit var signInProviderUseCase: SignInProviderUseCase

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        signInProviderUseCase = SignInProviderUseCase(authConfig, authRepository)
    }

    @Test
    fun `invoke should call signInMapper with the result of signInProvider`() = runTest {
        // Arrange
        val authType = AuthType.GOOGLE
        val token = "google_token"
        val userReq = UserReq(1, "John Doe", "john.doe@example.com", "password123")
        val signInResult = mockk<JsonObject>()
        val signInMappedResult = mockk<Ticket>()

        coEvery { authRepository.signInProvider(authType, token, userReq) } returns signInResult
        coEvery { authConfig.signInMapper(signInResult) } returns signInMappedResult

        // Act
        val result = signInProviderUseCase(authType, token, userReq)

        // Assert
        assertEquals(signInMappedResult, result)
        coEvery { authRepository.signInProvider(authType, token, userReq) }
        coEvery { authConfig.signInMapper(signInResult) }
    }
}
