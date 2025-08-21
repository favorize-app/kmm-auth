package multi.platform.auth.shared.compose.example

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMM Auth Compose Example",
        state = rememberWindowState()
    ) {
        App()
    }
}
