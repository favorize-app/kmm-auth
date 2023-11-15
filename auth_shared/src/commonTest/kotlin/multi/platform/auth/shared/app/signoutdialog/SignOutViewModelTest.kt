package multi.platform.auth.shared.app.signoutdialog

import io.ktor.utils.io.errors.IOException
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
import multi.platform.auth.shared.domain.auth.usecase.SignOutUseCase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class SignOutViewModelTest {
    private val signOutUseCase = mockk<SignOutUseCase>()
    private lateinit var signOutViewModel: SignOutViewModel

    // Global Arrange
    private val accessToken = "1234567890"

    @BeforeTest
    fun setup() = runTest {
        Dispatchers.setMain(StandardTestDispatcher(testScheduler))
        clearAllMocks()
        signOutViewModel = SignOutViewModel(signOutUseCase)
        signOutViewModel.useAsyncNetworkCall = false
        signOutViewModel.accessToken = accessToken
    }

    @Test
    fun `signOut should call signOutUseCase and update onSignOut when successful`() = runTest {
        coEvery { signOutUseCase(accessToken) } returns mockk()

        // Act
        signOutViewModel.signOut()
        advanceUntilIdle()

        // Assert
        coVerify { signOutUseCase(accessToken) }
        assertEquals(true, signOutViewModel.onSignOut.value)
    }

    @Test
    fun `signOut should update onException when an IOException occurs`() = runTest {
        val exception = IOException("Host not found")
        coEvery { signOutUseCase(accessToken) } throws exception

        // Act
        signOutViewModel.signOut()
        advanceUntilIdle()

        // Assert
        coVerify { signOutUseCase(accessToken) }
        assertEquals(exception, signOutViewModel.onException.value)
    }
}
