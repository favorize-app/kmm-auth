package multi.platform.auth.shared.app.forgetpassworddialog

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
import multi.platform.auth.shared.domain.auth.usecase.ForgetPasswordUseCase
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ForgetPasswordViewModelTest {
    private val forgetPasswordUseCase = mockk<ForgetPasswordUseCase>()
    private lateinit var forgetPasswordViewModel: ForgetPasswordViewModel

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        forgetPasswordViewModel = ForgetPasswordViewModel(forgetPasswordUseCase)
        forgetPasswordViewModel.useAsyncNetworkCall = false
    }

    @Test
    fun `submit should call forgetPasswordUseCase with the correct email`() = runTest {
        // Arrange
        val email = "test@example.com"
        forgetPasswordViewModel.email.value = email
        forgetPasswordViewModel.emailError.value = null

        coEvery { forgetPasswordUseCase.call(email) } returns mockk()

        // Act
        forgetPasswordViewModel.submit()
        advanceUntilIdle()

        // Assert
        coVerify { forgetPasswordUseCase.call(email) }
    }

    @Test
    fun `submit should not call forgetPasswordUseCase if email is null or empty`() = runTest {
        // Arrange
        forgetPasswordViewModel.email.value = null
        forgetPasswordViewModel.emailError.value = null

        // Act
        forgetPasswordViewModel.submit()
        advanceUntilIdle()

        // Assert
        coVerify(exactly = 0) { forgetPasswordUseCase.call(any()) }

        // Arrange
        forgetPasswordViewModel.email.value = ""
        forgetPasswordViewModel.emailError.value = null

        // Act
        forgetPasswordViewModel.submit()
        advanceUntilIdle()

        // Assert
        coVerify(exactly = 0) { forgetPasswordUseCase.call(any()) }
    }

    @Test
    fun `submit should not call forgetPasswordUseCase if emailError is not null`() = runTest {
        // Arrange
        val email = "test@example.com"
        val emailError = "Invalid email"
        forgetPasswordViewModel.email.value = email
        forgetPasswordViewModel.emailError.value = emailError

        // Act
        forgetPasswordViewModel.submit()
        advanceUntilIdle()

        // Assert
        coVerify(exactly = 0) { forgetPasswordUseCase.call(any()) }
    }
}
