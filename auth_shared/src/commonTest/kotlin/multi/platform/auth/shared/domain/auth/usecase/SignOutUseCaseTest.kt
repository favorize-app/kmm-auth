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
class SignOutUseCaseTest {
    private val authConfig = mockk<AuthConfig>()
    private val authRepository = mockk<AuthRepository>()
    private lateinit var signOutUseCase: SignOutUseCase

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        signOutUseCase = SignOutUseCase(authConfig, authRepository)
    }

    @Test
    fun `invoke should call signOutMapper with the result of signOut`() = runTest {
        // Arrange
        val accessToken = "123456"
        val signOutResult = mockk<JsonObject>()
        val signOutMappedResult = mockk<Ticket>()

        coEvery { authRepository.signOut(accessToken) } returns signOutResult
        coEvery { authConfig.signOutMapper(signOutResult) } returns signOutMappedResult

        // Act
        val result = signOutUseCase(accessToken)

        // Assert
        assertEquals(signOutMappedResult, result)
        coEvery { authRepository.signOut(accessToken) }
        coEvery { authConfig.signOutMapper(signOutResult) }
    }
}
