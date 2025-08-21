import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.renderComposable
import multi.platform.auth.shared.compose.ComposeAuthExample

fun main() {
    window.onload = {
        document.getElementById("root")?.let { root ->
            renderComposable(root) {
                ComposeAuthExample()
            }
        }
    }
}
