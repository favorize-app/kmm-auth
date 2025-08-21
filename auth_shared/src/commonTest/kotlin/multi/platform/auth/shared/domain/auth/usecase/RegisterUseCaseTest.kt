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
import multi.platform.auth.shared.data.auth.network.payload.UserPayload
import multi.platform.auth.shared.domain.auth.AuthRepository
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.external.AuthConfig
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class RegisterUseCaseTest {
    private val authConfig = mockk<AuthConfig>()
    private val authRepository = mockk<AuthRepository>()
    private lateinit var registerUseCase: RegisterUseCase

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        registerUseCase = RegisterUseCase(authConfig, authRepository)
    }

    @Test
    fun `invoke should call registerMapper with the result of register`() = runTest {
        // Arrange
        val trxid = "123456"
        val userPayload = UserPayload(1, "John Doe", "john.doe@example.com", "password123")
        val imageBytes = byteArrayOf(0x01, 0x02, 0x03)
        val imageName = "profile.jpg"
        val registerResult = mockk<JsonObject>()
        val registerMappedResult = mockk<Ticket>()

        coEvery { authRepository.register(trxid, userPayload, imageBytes, imageName) } returns registerResult
        coEvery { authConfig.registerMapper(registerResult) } returns registerMappedResult

        // Act
        val result = registerUseCase.call(trxid, userPayload, imageBytes, imageName)

        // Assert
        assertEquals(registerMappedResult, result)
        coEvery { authRepository.register(trxid, userPayload, imageBytes, imageName) }
        coEvery { authConfig.registerMapper(registerResult) }
    }
}
