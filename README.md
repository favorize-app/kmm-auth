# Multi Platform Auth

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![pipeline status](https://gitlab.com/kotlin-multiplatform-mobile/auth/badges/main/pipeline.svg)](https://gitlab.com/kotlin-multiplatform-mobile/auth/-/commits/main) [![coverage report](https://gitlab.com/kotlin-multiplatform-mobile/auth/badges/main/coverage.svg)](https://gitlab.com/kotlin-multiplatform-mobile/auth/-/commits/main) [![Latest Release](https://gitlab.com/kotlin-multiplatform-mobile/auth/-/badges/release.svg)](https://gitlab.com/kotlin-multiplatform-mobile/auth/-/releases)

## Contents

- [Documentation](https://gitlab.com/tossaro/kotlin-multi-platform-auth/tree/main/docs)
- [Features](#features)
- [Requirements](#requirements)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Architecture](#architecture)
- [Commands](#commands)

## Features

- Provide Sign In with multiple provider:
    - Google
    - Facebook
    - Email
    - Phone
- Provide Verify OTP Dialog
- Provide complete registration for new user with detail:
    - Avatar
    - Name
    - Bio
    - Email
- Powered by KOIN for dependency injection and using MVVM pattern with clean architecture.

## Requirements

1. Minimum Android/SDK Version: 24
2. Deployment Target iOS/SDK Version: 14.1
3. Target Android/SDK Version: 34
4. Compile Android/SDK Version: 34
5. This project is built using Android Studio version 2023.1.1 and Android Gradle 8.2
6. For iOS, please install [COCOAPODS](https://cocoapods.org/)

## Usage

1. Edit settings.gradle in your root folder:

```groovy
dependencyResolutionManagement {
    repositories {
        //...
        maven { url 'https://gitlab.com/api/v4/projects/38961532/packages/maven' }
    }
}
```

2. Last, add 'implementation "multi.platform.auth:auth_shared:${version}"' inside tag
   dependencies { . . . } of build.gradle app

For the high level hierarchy, the project separate into 2 main modules, which are :

### 1. [Core iOS](https://gitlab.com/kotlin-multiplatform-mobile/auth/tree/main/core_ios)

This module contains iOS code that holds the iOS library, that can be injected to iOS app.

### 2. [Core Shared](https://gitlab.com/kotlin-multiplatform-mobile/auth/tree/main/core_shared)

This module contains shared code that holds the domain and data layers and some part of the
presentation logic ie.shared viewmodels.

## Project Structure

```plantuml
:auth_shared;
fork
    :example_android;
fork again
    :auth_ios;
    :example_ios;
end fork
end
```


## Architecture

This project implement
Clean [Architecture by Fernando Cejas](https://github.com/android10/Android-CleanArchitecture)

### Clean architecture

![Image Clean architecture](/resources/clean_architecture.png)

### Architectural approach

![Image Architectural approach](/resources/clean_architecture_layers.png)

### Architectural reactive approach

![Image Architectural reactive approach](/resources/clean_architecture_layers_details.png)

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