package multi.platform.auth.shared.compose.example

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier
) {
    var isSignIn by remember { mutableStateOf(true) }
    var showPassword by remember { mutableStateOf(false) }
    
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Auth Type Toggle
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            FilterChip(
                selected = isSignIn,
                onClick = { isSignIn = true },
                label = { Text("Sign In") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Login,
                        contentDescription = "Sign In"
                    )
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            FilterChip(
                selected = !isSignIn,
                onClick = { isSignIn = false },
                label = { Text("Register") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.PersonAdd,
                        contentDescription = "Register"
                    )
                }
            )
        }
        
        if (isSignIn) {
            SignInContent(
                showPassword = showPassword,
                onShowPasswordChange = { showPassword = it }
            )
        } else {
            RegisterContent(
                showPassword = showPassword,
                onShowPasswordChange = { showPassword = it }
            )
        }
        
        // Social Sign In Options
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { /* TODO: Implement Google sign in */ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Google,
                    contentDescription = "Google",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Google")
            }
            
            Spacer(modifier = Modifier.width(8.dp))
            
            OutlinedButton(
                onClick = { /* TODO: Implement Facebook sign in */ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.Facebook,
                    contentDescription = "Facebook",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Facebook")
            }
        }
        
        // Biometric Sign In
        if (isSignIn) {
            OutlinedButton(
                onClick = { /* TODO: Implement biometric sign in */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Fingerprint,
                    contentDescription = "Biometric",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Sign in with Biometric")
            }
        }
    }
}

@Composable
private fun SignInContent(
    showPassword: Boolean,
    onShowPasswordChange: (Boolean) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        
        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )
            },
            trailingIcon = {
                IconButton(onClick = { onShowPasswordChange(!showPassword) }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (showPassword) "Hide password" else "Show password"
                    )
                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        
        // Forgot Password Link
        TextButton(
            onClick = { /* TODO: Implement forgot password */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Forgot Password?")
        }
        
        // Sign In Button
        Button(
            onClick = { 
                // TODO: Implement sign in logic
                println("Sign in with email: $email, password: $password")
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = email.isNotEmpty() && password.isNotEmpty()
        ) {
            Text("Sign In")
        }
    }
}

@Composable
private fun RegisterContent(
    showPassword: Boolean,
    onShowPasswordChange: (Boolean) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Name Field
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Full Name") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Name"
                )
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        
        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        
        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password"
                )
            },
            trailingIcon = {
                IconButton(onClick = { onShowPasswordChange(!showPassword) }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (showPassword) "Hide password" else "Show password"
                    )
                }
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        
        // Confirm Password Field
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Confirm Password"
                )
            },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        
        // Register Button
        Button(
            onClick = { 
                // TODO: Implement registration logic
                if (email.isNotEmpty() && password.isNotEmpty() && 
                    confirmPassword.isNotEmpty() && name.isNotEmpty() &&
                    password == confirmPassword) {
                    println("Register with name: $name, email: $email, password: $password")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = email.isNotEmpty() && password.isNotEmpty() && 
                     confirmPassword.isNotEmpty() && name.isNotEmpty() &&
                     password == confirmPassword
        ) {
            Text("Create Account")
        }
    }
}
