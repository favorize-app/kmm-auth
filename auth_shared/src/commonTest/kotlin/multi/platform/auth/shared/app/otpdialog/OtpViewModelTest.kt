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
import multi.platform.auth.shared.app.otpdialog.OtpViewModel
import multi.platform.auth.shared.domain.auth.entity.Ticket
import multi.platform.auth.shared.domain.auth.usecase.AuthorizationUseCase
import multi.platform.auth.shared.domain.auth.usecase.VerifyOtpUseCase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class OtpViewModelTest {
    private val authorizationUseCase = mockk<AuthorizationUseCase>()
    private val verifyOtpUseCase = mockk<VerifyOtpUseCase>()
    private lateinit var otpViewModel: OtpViewModel

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        otpViewModel = OtpViewModel(authorizationUseCase, verifyOtpUseCase)
        otpViewModel.useAsyncNetworkCall = false
    }

    @Test
    fun `verifyOtp should call verifyOtpUseCase with the correct parameters`() = runTest {
        // Arrange
        val otp = "123456"
        val type = "LOGIN"
        val country = "US"
        val phone = "1234567890"
        otpViewModel.state.value = "null"
        otpViewModel.country.value = country
        otpViewModel.phone.value = phone

        coEvery { verifyOtpUseCase.call(otp, type, country + phone) } returns mockk()

        // Act
        otpViewModel.verifyOtp(otp)
        advanceUntilIdle()

        // Assert
        coVerify { verifyOtpUseCase.call(otp, type, country + phone) }
    }

    @Test
    fun `verifyOtp should update onSignedIn when type is LOGIN`() = runTest {
        // Arrange
        val otp = "123456"
        val type = "LOGIN"
        val country = "US"
        val phone = "1234567890"
        otpViewModel.state.value = "null"
        otpViewModel.country.value = country
        otpViewModel.phone.value = phone

        val ticket = mockk<Ticket>()
        coEvery { verifyOtpUseCase.call(otp, type, country + phone) } returns ticket

        // Act
        otpViewModel.verifyOtp(otp)
        advanceUntilIdle()

        // Assert
        assertEquals(ticket, otpViewModel.onSignedIn.value)
    }

    @Test
    fun `verifyOtp should update onOTPVerifyRegister when type is not LOGIN`() = runTest {
        // Arrange
        val otp = "123456"
        val type = "ONBOARDING"
        val country = "US"
        val phone = "1234567890"
        otpViewModel.state.value = "email"
        otpViewModel.country.value = country
        otpViewModel.phone.value = phone

        val ticket = mockk<Ticket>()
        coEvery { verifyOtpUseCase.call(otp, type, country + phone) } returns ticket

        // Act
        otpViewModel.verifyOtp(otp)
        advanceUntilIdle()

        // Assert
        assertEquals(ticket, otpViewModel.onOTPVerifyRegister.value)
    }
}
