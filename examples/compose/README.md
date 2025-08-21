# KMM Auth Compose Multiplatform Example

This example demonstrates how to use the KMM Auth library with Compose Multiplatform to create a cross-platform authentication UI.

## Features

- **Cross-platform UI**: Works on Android, iOS, Desktop, and Web
- **Material Design 3**: Modern Material Design components
- **Authentication Flow**: Sign in, registration, and social authentication
- **Responsive Design**: Adapts to different screen sizes and orientations

## Project Structure

```
src/
├── commonMain/          # Shared code for all platforms
│   └── kotlin/
│       ├── App.kt              # Main app composable
│       └── ComposeAuthExample.kt # Entry point
├── androidMain/         # Android-specific code
│   └── kotlin/
│       └── MainActivity.kt     # Android activity
├── iosMain/            # iOS-specific code
│   └── kotlin/
│       └── Main.kt            # iOS view controller
├── desktopMain/        # Desktop-specific code
│   └── kotlin/
│       └── Main.kt            # Desktop main function
├── jsMain/            # JavaScript web code
│   ├── kotlin/
│   │   └── Main.kt           # Web main function
│   └── resources/
│       └── index.html        # HTML template
└── wasmJsMain/        # WASM web code
    ├── kotlin/
    │   └── Main.kt           # WASM main function
    └── resources/
        └── index.html        # HTML template
```

## Running the Example

### Android
```bash
./gradlew :examples:compose:androidMainClasses
./gradlew :examples:compose:androidDebug
```

### iOS
```bash
./gradlew :examples:compose:iosSimulatorArm64MainClasses
# Open in Xcode and run on simulator
```

### Desktop
```bash
./gradlew :examples:compose:desktopMainClasses
./gradlew :examples:compose:desktopRun
```

### Web (JavaScript)
```bash
./gradlew :examples:compose:jsBrowserDevelopmentRun
```

### Web (WASM)
```bash
./gradlew :examples:compose:wasmJsBrowserDevelopmentRun
```

## Components

### AuthScreen
The main authentication component that provides:
- Sign in/registration toggle
- Email and password fields
- Social authentication options (Google, Facebook)
- Biometric authentication
- Form validation

### App
The main application wrapper that:
- Sets up Material Design 3 theme
- Provides consistent styling
- Handles layout and spacing

## Integration with KMM Auth

The example uses the `AuthScreen` component from the `auth_shared` module, which integrates with:
- `SignInViewModel` for authentication logic
- `RegisterViewModel` for user registration
- Domain entities and use cases
- Platform-specific authentication providers

## Customization

You can customize the authentication flow by:
1. Injecting your own ViewModels
2. Modifying the UI components
3. Adding custom validation logic
4. Implementing platform-specific features

## Dependencies

The example uses:
- Compose Multiplatform 1.6.0
- Material Design 3 components
- KMM Auth shared library
- Platform-specific implementations

## Troubleshooting

### Build Issues
- Ensure all dependencies are properly configured
- Check that the auth_shared module is built first
- Verify Compose Multiplatform version compatibility

### Runtime Issues
- Check platform-specific logs
- Verify ViewModel injection
- Ensure proper resource loading

## Next Steps

To extend this example:
1. Add real authentication logic
2. Implement navigation between screens
3. Add error handling and loading states
4. Integrate with backend services
5. Add unit and UI tests
