plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.application")
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm("desktop")
    js(IR) {
        browser()
        binaries.executable()
    }
    wasmJs {
        browser()
        binaries.executable()
    }
    
    cocoapods {
        version = "1.0.0"
        summary = "KMM Auth Compose Multiplatform Example"
        homepage = "https://github.com/favorize-app/kmm-auth"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios/Podfile")
        framework {
            baseName = "ComposeAuthExample"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }
    
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":auth_shared"))
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(compose.material.iconsExtended)
            }
        }
        
        androidMain {
            dependencies {
                implementation(compose.uiTooling)
                implementation(compose.preview)
            }
        }
        
        iosMain {
            dependencies {
                implementation(compose.uiTooling)
                implementation(compose.preview)
            }
        }
        
        desktopMain {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(compose.uiTooling)
                implementation(compose.preview)
            }
        }
        
        jsMain {
            dependencies {
                implementation(compose.uiTooling)
                implementation(compose.preview)
            }
        }
        
        wasmJsMain {
            dependencies {
                implementation(compose.uiTooling)
                implementation(compose.preview)
            }
        }
    }
}

android {
    namespace = "multi.platform.auth.shared.compose.example"
    compileSdk = 34
    
    defaultConfig {
        applicationId = "multi.platform.auth.shared.compose.example"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    
    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
}
