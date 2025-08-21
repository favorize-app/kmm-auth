package multi.platform.auth.shared.compose.example

import androidx.compose.web.renderComposable
import org.jetbrains.compose.web.dom.Body
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text

fun main() {
    renderComposable(rootElementId = "root") {
        Body {
            Div {
                H1 {
                    Text("KMM Auth Compose Example - WASM")
                }
                // Note: AuthScreen is not yet compatible with Compose for Web
                // This is a placeholder until web compatibility is implemented
                Div {
                    Text("Authentication UI will be available here")
                }
            }
        }
    }
}
