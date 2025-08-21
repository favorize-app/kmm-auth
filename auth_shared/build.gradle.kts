@file:Suppress("UNUSED_VARIABLE", "UnstableApiUsage")

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import groovy.util.Node
import groovy.util.NodeList
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFrameworkConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kover)
    kotlin("native.cocoapods")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    id("kotlinx-serialization")
    `maven-publish`
}

val repoId: String by project
val appId: String by project
val appName: String by project
val appVersionName: String by project
val androidCompileSdkVersion: String by project
val androidMinSdkVersion: String by project
val iosDeploymentTarget: String by project
val localProperties = gradleLocalProperties(rootDir, providers)

group = appId
version = appVersionName

android {
    namespace = "$appId.shared"
    compileSdk = androidCompileSdkVersion.toInt()
    defaultConfig {
        minSdk = androidMinSdkVersion.toInt()

        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            setProguardFiles(mutableListOf("proguard-rules.pro"))
        }
        getByName("debug") {
            isMinifyEnabled = false
            enableUnitTestCoverage = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        buildConfig = true
        dataBinding = true
    }
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget {
        @OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
        publishLibraryVariants("release", "debug")
    }
    
    // Desktop (JVM) target for desktop applications
    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    
    // Traditional JavaScript target for broader browser support
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "favorize-auth-legacy.js"
            }
        }
        nodejs()
        generateTypeScriptDefinitions()
    }
    
    // Web target using WASM (modern browsers with better performance)
    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "favorize-auth-wasm.js"
            }
        }
        nodejs()
    }

    val xcf = XCFrameworkConfig(project)
    cocoapods {
        summary = "Provide Sign In with multiple provider"
        homepage = "https://gitlab.com/kotlin-multiplatform-mobile/auth"
        version = appVersionName
        ios.deploymentTarget = iosDeploymentTarget
        framework {
            isStatic = false
            xcf.add(this)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // HTTP client for API calls - multiplatform API (actual implementations are platform-specific, e.g. ktor-client-okhttp for Android, ktor-client-darwin for iOS, ktor-client-js for web)
                api(libs.kmm.core)
                // HTTP client for API calls\
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.kotlinx.serialization.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-annotations-common"))
                implementation(libs.coroutines.test)
                implementation(libs.mockk.common)
            }
        }
        val androidMain by getting {
            dependencies {
                api(libs.gms.auth)
                api(libs.fb)
                api(libs.biometric)
                api(libs.onesignal)
                
                // HTTP client implementation for Android
                implementation(libs.ktor.client.okhttp)
            }
            resources.srcDir("./res")
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation(libs.junit)
                implementation(libs.mockk)
            }
        }
        val iosMain by getting {
            dependencies {
                // Mobile-specific core dependency
                api(libs.kmm.core)
                // HTTP client implementation for iOS
                implementation(libs.ktor.client.darwin)
            }
        }
        
        val jsMain by getting {
            dependencies {
                // HTTP client implementation for traditional JavaScript
                implementation(libs.ktor.client.js)
            }
        }
        
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        
        val wasmJsMain by getting {
            dependencies {
                // HTTP client implementation for Web/WASM
                implementation(libs.ktor.client.js)
            }
        }
        
        val wasmJsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        
        val desktopMain by getting {
            dependencies {
                // Desktop-specific dependencies
                implementation(libs.ktor.client.okhttp) // Use OkHttp client for JVM
            }
        }
        
        val desktopTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(libs.junit)
                implementation(libs.mockk)
            }
        }
    }
}

// Publishing configuration temporarily disabled to fix build issues
// TODO: Re-enable with proper Gradle 8.14+ syntax
/*
publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["kotlin"])
            pom.withXml {
                val dependencies =
                    ((asNode()["dependencies"] as NodeList)[0] as Node).value() as NodeList
                if (dependencies.isNotEmpty()) {
                    dependencies.map { it as Node }.forEach {
                        val scope = (it["scope"] as NodeList)[0] as Node
                        scope.setValue("compile")
                    }
                }
            }
        }
    }
    repositories {
        maven {
            name = appName
            url = uri("https://gitlab.com/api/v4/projects/${repoId}/packages/maven")
            credentials(HttpHeaderCredentials::class) {
                name = "Deploy-Token"
                value = localProperties.getProperty("token")
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
}
*/

// TODO: Update Kover configuration for new version
// Temporarily removed to fix build issues