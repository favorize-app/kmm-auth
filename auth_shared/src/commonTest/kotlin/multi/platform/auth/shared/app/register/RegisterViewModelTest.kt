package multi.platform.auth.shared.app.register

import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import multi.platform.auth.shared.data.auth.network.request.UserReq
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.domain.auth.usecase.RegisterUseCase
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RegisterViewModelTest {
    private val registerUseCase = mockk<RegisterUseCase>()
    private lateinit var registerViewModel: RegisterViewModel

    // Global Arrange
    private val imageBytes = byteArrayOf(0x01, 0x02, 0x03)
    private val imageName = "profile.jpg"

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        registerViewModel = RegisterViewModel(registerUseCase)
        registerViewModel.useAsyncNetworkCall = false
    }

    @Test
    fun `register should call registerUseCase with the correct parameters`() = runTest {
        // Arrange
        registerViewModel.transactionId = "123456"
        registerViewModel.name.value = "John Doe"
        registerViewModel.bio.value = "Software Developer"
        registerViewModel.email.value = "john.doe@example.com"
        registerViewModel.country.value = "US"
        registerViewModel.phone.value = "1234567890"
        registerViewModel.password.value = "Password@123"
        registerViewModel.passwordConfirm.value = "Password@123"
        registerViewModel.requirePassword.value = true

        val userReq = UserReq(
            0,
            registerViewModel.name.value,
            registerViewModel.bio.value,
            registerViewModel.email.value,
            registerViewModel.country.value,
            registerViewModel.phone.value,
            registerViewModel.password.value,
        )
        val ticket = mockk<Ticket>()
        coEvery { registerUseCase(registerViewModel.transactionId, userReq, imageBytes, imageName) } returns ticket

        // Act
        registerViewModel.register(imageBytes, imageName)
        advanceUntilIdle()

        // Assert
        coVerify {
            registerUseCase(
                registerViewModel.transactionId,
                userReq,
                imageBytes,
                imageName,
            )
        }
    }

    @Test
    fun `register should not call registerUseCase if validation fails`() = runTest {
        // Arrange
        val userReq = mockk<UserReq>()
        registerViewModel.email.value = "wrong-email"
        registerViewModel.password.value = "weak-password"
        registerViewModel.requirePassword.value = true

        val ticket = mockk<Ticket>()
        coEvery { registerUseCase(registerViewModel.transactionId, userReq, imageBytes, imageName) } returns ticket

        // Act
        registerViewModel.register(imageBytes, imageName)
        advanceUntilIdle()

        // Assert
        coVerify(exactly = 0) {
            registerUseCase(
                registerViewModel.transactionId,
                userReq,
                imageBytes,
                imageName,
            )
        }
    }
}
