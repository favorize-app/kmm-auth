package multi.platform.auth.shared.compose.example

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import multi.platform.auth.shared.compose.AuthScreen

@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "🔐 KMM Auth Compose Example",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                Text(
                    text = "Cross-platform authentication UI",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                Spacer(modifier = Modifier.height(32.dp))
                
                // AuthScreen without ViewModels for demo purposes
                // In a real app, you would inject the ViewModels here
                AuthScreen(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
