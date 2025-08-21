@file:Suppress("UnstableApiUsage", "DataBindingWithoutKapt")

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
// Removed deprecated import

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlinx-serialization")
}

val appId: String by project
val appName: String by project
val appVersionName: String by project
val appVersionCode: String by project
val androidCompileSdkVersion: String by project
val androidTargetSdkVersion: String by project
val androidMinSdkVersion: String by project
val iosDeploymentTarget: String by project
val localProperties = gradleLocalProperties(rootDir, providers)

android {
    namespace = "$appId.example"
    compileSdk = androidCompileSdkVersion.toInt()
    defaultConfig {
        applicationId = "$appId.example"
        minSdk = androidMinSdkVersion.toInt()
        targetSdk = androidTargetSdkVersion.toInt()
        versionCode = appVersionCode.toInt()
        versionName = appVersionName

        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        manifestPlaceholders["host"] = "example.com"
        manifestPlaceholders["fb_app_id"] = "123456789"
        manifestPlaceholders["fb_client_token"] = "example_token"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
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

    kotlin {
        jvmToolchain(17)
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }

    // Simplified build configuration for examples
}

dependencies {
    implementation(project(":auth_shared"))
    implementation(libs.onesignal)
    testImplementation(libs.junit)
}