package multi.platform.auth.shared.app.signin

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
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.domain.auth.usecase.AuthorizationUseCase
import multi.platform.auth.shared.domain.auth.usecase.SignInEmailUseCase
import multi.platform.auth.shared.domain.auth.usecase.SignInProviderUseCase
import multi.platform.auth.shared.domain.auth.usecase.ValidatePhoneUseCase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class SignInViewModelTest {
    private val authorizationUseCase = mockk<AuthorizationUseCase>()
    private val validatePhoneUseCase = mockk<ValidatePhoneUseCase>()
    private val signInEmailUseCase = mockk<SignInEmailUseCase>()
    private val signInProviderUseCase = mockk<SignInProviderUseCase>()
    private lateinit var signInViewModel: SignInViewModel

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        signInViewModel = SignInViewModel(
            authorizationUseCase,
            validatePhoneUseCase,
            signInEmailUseCase,
            signInProviderUseCase,
        )
        signInViewModel.useAsyncNetworkCall = false
    }

    @Test
    fun `signInPhone should call authorizationUseCase and update onCheckPhone`() = runTest {
        // Arrange
        val country = "US"
        val phone = "1234567890"
        val response = mockk<Ticket>()

        coEvery { authorizationUseCase.call("$country$phone") } returns response

        // Act
        signInViewModel.country.value = country
        signInViewModel.phone.value = phone
        signInViewModel.signInPhone()
        advanceUntilIdle()

        // Assert
        coVerify { authorizationUseCase.call("$country$phone") }
        assertEquals(response, signInViewModel.onCheckPhone.value)
    }
}
