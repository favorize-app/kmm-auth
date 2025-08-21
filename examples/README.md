# KMM Auth Examples

This directory contains comprehensive examples demonstrating how to use the KMM Auth module across different platforms.

## 📱 Platform Examples

### Android (`examples/android/`)
- **Purpose**: Native Android application using KMM Auth
- **Features**: Full Android integration with Material Design
- **Build**: `./gradlew :examples:android:assembleDebug`
- **Run**: Install APK on Android device/emulator

### iOS (`examples/ios/`)
- **Purpose**: Native iOS application using KMM Auth
- **Features**: iOS-specific UI components and navigation
- **Build**: `./gradlew :examples:ios:linkDebugFrameworkIosArm64`
- **Run**: Open in Xcode and run on iOS device/simulator

### Web (`examples/web/`)
- **Purpose**: Web application using KMM Auth
- **Features**: JavaScript and WebAssembly targets
- **Build**: 
  - JS: `./gradlew :examples:web:jsBrowserDevelopmentRun`
  - WASM: `./gradlew :examples:web:wasmJsBrowserDevelopmentRun`
- **Run**: Open `build/dist/jsMain/developmentExecutable/index.html` in browser

### Desktop (`examples/desktop/`)
- **Purpose**: Desktop application using KMM Auth
- **Features**: Cross-platform desktop UI with Compose for Desktop
- **Build**: `./gradlew :examples:desktop:run`
- **Run**: Executable JAR or native distribution

### Compose Multiplatform (`examples/compose/`)
- **Purpose**: Universal UI across all platforms
- **Features**: Single codebase for Android, iOS, Desktop, Web
- **Build**: 
  - Android: `./gradlew :examples:compose:assembleDebug`
  - iOS: `./gradlew :examples:compose:linkDebugFrameworkIosArm64`
  - Desktop: `./gradlew :examples:compose:run`
  - Web: `./gradlew :examples:compose:jsBrowserDevelopmentRun`
- **Run**: Platform-specific execution

## 🚀 Quick Start

1. **Build all examples**:
   ```bash
   ./gradlew build
   ```

2. **Run specific example**:
   ```bash
   # Android
   ./gradlew :examples:android:assembleDebug
   
   # Desktop
   ./gradlew :examples:desktop:run
   
   # Web (JS)
   ./gradlew :examples:web:jsBrowserDevelopmentRun
   ```

3. **Clean builds**:
   ```bash
   ./gradlew clean
   ```

## 🔧 Configuration

Each example has its own `build.gradle.kts` file with platform-specific configurations:

- **Dependencies**: Platform-specific Compose and KMM Auth modules
- **Targets**: Optimized for each platform's capabilities
- **Resources**: Platform-appropriate assets and configurations

## 📚 Learning Path

1. Start with **Android** example for basic authentication flow
2. Explore **iOS** example for mobile-specific patterns
3. Try **Desktop** example for cross-platform UI concepts
4. Experiment with **Web** examples for browser integration
5. Master **Compose Multiplatform** for universal solutions

## 🎯 Key Features Demonstrated

- **Authentication Flow**: Sign in, sign up, password reset
- **Platform Integration**: Native UI components and navigation
- **State Management**: ViewModels and reactive UI updates
- **Error Handling**: User-friendly error messages and validation
- **Responsive Design**: Adaptive layouts for different screen sizes

## 🐛 Troubleshooting

- **Build Issues**: Check platform-specific requirements
- **Runtime Errors**: Verify authentication configuration
- **UI Problems**: Ensure Compose version compatibility
- **Platform Issues**: Check target SDK/OS version requirements

## 📖 Next Steps

After exploring the examples:

1. **Customize**: Modify authentication flows for your needs
2. **Extend**: Add new authentication methods
3. **Integrate**: Use in your own KMM projects
4. **Contribute**: Share improvements with the community

## 🔗 Related Documentation

- [Architecture Overview](../docs/ARCHITECTURE.md)
- [Standalone Usage](../docs/STANDALONE_USAGE.md)
- [Platform Support](../docs/UNIVERSAL_PLATFORM_SUPPORT.md)
- [Compilation Status](../docs/COMPILATION_STATUS.md)
