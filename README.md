# KMM Auth - Standalone Authentication Module

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![pipeline status](https://gitlab.com/kotlin-multiplatform-mobile/auth/badges/main/pipeline.svg)](https://gitlab.com/kotlin-multiplatform-mobile/auth/-/commits/main) [![coverage report](https://gitlab.com/kotlin-multiplatform-mobile/auth/badges/main/coverage.svg)](https://gitlab.com/kotlin-multiplatform-mobile/auth/-/commits/main) [![Latest Release](https://gitlab.com/kotlin-multiplatform-mobile/auth/-/badges/release.svg)](https://gitlab.com/kotlin-multiplatform-mobile/auth/-/releases)

## 🚀 **NEW: Standalone Architecture**

**This module is now completely standalone!** 🎉 No external dependencies on KMM Core or other heavy libraries. Ready for production use.

## Contents

- [Documentation](docs/)
  - [Auth Module Guide](docs/AUTH_MODULE_GUIDE.md)
  - [API Reference](docs/API_REFERENCE.md)
  - [Usage Examples](docs/USAGE_EXAMPLES.md)
  - [Migration Guide](MIGRATION_GUIDE.md)
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Commands](#commands)

## Features

- **🔐 Authentication Providers**:
  - Google OAuth
  - Facebook OAuth
  - Email/Password
  - Phone/SMS
  - Biometric authentication (Android)
- **📱 Cross-Platform Support**:
  - Android (OkHttp engine)
  - iOS (Darwin engine)
  - Desktop/JVM (OkHttp engine)
  - JavaScript/Web (JS engine)
  - WebAssembly (JS engine)
- **🎯 Complete User Flows**:
  - User registration with avatar, name, bio, email
  - OTP verification dialog
  - Password reset
  - Sign out
- **🏗️ Modern Architecture**:
  - MVVM pattern with clean architecture
  - Manual dependency injection (no external DI frameworks)
  - Coroutines for async operations
  - StateFlow for reactive state management

## Requirements

1. Minimum Android/SDK Version: 24
2. Deployment Target iOS/SDK Version: 14.1
3. Target Android/SDK Version: 34
4. Compile Android/SDK Version: 34
5. This project is built using Android Studio version 2023.1.1 and Android Gradle 8.2
6. For iOS, please install [COCOAPODS](https://cocoapods.org/)

## Quick Start

### 1. Add Repository

Edit `settings.gradle.kts` in your root folder:

```kotlin
dependencyResolutionManagement {
    repositories {
        // ... other repositories
        maven { url = uri("https://gitlab.com/api/v4/projects/38961532/packages/maven") }
    }
}
```

### 2. Add Dependency

Add to your module's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("multi.platform.auth:auth_shared:$version")
}
```

### 3. Initialize the Module

```kotlin
import multi.platform.auth.shared.createAuthModule
import multi.platform.auth.shared.external.AuthConfig

// Create your AuthConfig implementation
val authConfig = object : AuthConfig {
    override val isDebugMode: Boolean = BuildConfig.DEBUG
    // ... implement other required properties
}

// Create the auth module (platform-specific)
val authModule = createAuthModule(authConfig)

// Use ViewModels
val signInViewModel = authModule.createSignInViewModel()
val registerViewModel = authModule.createRegisterViewModel()
```

### 4. Platform-Specific Setup

See [Usage Examples](docs/USAGE_EXAMPLES.md) for detailed platform-specific integration guides.

## Project Structure

```
kmm-auth-dev/
├── auth_shared/                    # ✅ Standalone Auth Module
│   ├── src/
│   │   ├── commonMain/            # Shared Kotlin code
│   │   ├── androidMain/           # Android-specific implementations
│   │   ├── iosMain/               # iOS-specific implementations
│   │   ├── jsMain/                # JavaScript/Web implementations
│   │   ├── wasmJsMain/            # WebAssembly implementations
│   │   └── jvmMain/               # Desktop/JVM implementations
│   └── build.gradle.kts
├── examples/
│   └── compose/                   # Compose Multiplatform example
├── docs/                          # 📚 Documentation
│   ├── AUTH_MODULE_GUIDE.md
│   ├── API_REFERENCE.md
│   └── USAGE_EXAMPLES.md
└── MIGRATION_GUIDE.md            # Migration from KMM Core
```

## Architecture

### 🏗️ Standalone Architecture

The module now uses a **lightweight, standalone architecture** with:

- **BaseViewModel**: Lightweight ViewModel base class
- **BaseUseCase**: Standalone UseCase base class  
- **Manual DI**: Direct dependency injection without external frameworks
- **Platform-specific HTTP clients**: Optimized for each platform
- **Shared business logic**: Common authentication flows

### 🔄 Clean Architecture Layers

```
┌─────────────────────────────────────────┐
│             Presentation Layer          │
│  (ViewModels, Compose UI, Platform UI)  │
├─────────────────────────────────────────┤
│             Domain Layer                │
│     (Use Cases, Entities, Repository    │
│         Interfaces, Validation)         │
├─────────────────────────────────────────┤
│              Data Layer                 │
│   (Repository Implementations, DTOs,    │
│      Network, Platform-specific)        │
└─────────────────────────────────────────┘
```

### 🌐 Platform Support

- **Android**: OkHttp + Material Design
- **iOS**: Darwin engine + Native iOS UI
- **Desktop**: OkHttp + Compose Desktop
- **Web**: JS engine + Compose Web
- **WASM**: JS engine + Compose WASM

## Commands

Here are some useful gradle/adb commands for executing this example:

* ./gradlew clean build - Build the entire project and execute unit tests
* ./gradlew clean sonarqube - Execute sonarqube coverage report
* ./gradlew assembleStoreDebug dokkaGfm - Generate documentation
* ./gradlew lintStoreDebug - Run linter
* ./gradlew spotlessApply - Run apply spotless
* ./gradlew test{flavor}{buildType}UnitTest - Execute unit tests e.g., testStoreDebugUnitTest
* ./gradlew testStoreDebugUnitTest koverXmlReport - Generate coverage report
* ./gradlew assemble{flavor}{buildType} - Create apk/aar file e.g., assembleStoreDebug
* ./gradlew :auth_shared:assembleXCFramework - Generate XCFramework for iOS
* ./gradlew assembleStoreDebug publish - Publish - Publish to repository packages (MAVEN)