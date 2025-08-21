import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import multi.platform.auth.shared.compose.AuthScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMM Auth Desktop Example",
        state = rememberWindowState()
    ) {
        AuthScreen()
    }
}
