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

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }

    flavorDimensions += "api"
    productFlavors {
        val mainFlavour = localProperties.getProperty("mainFlavor")
        val flavours = localProperties.getProperty("flavors").split(",")
        flavours.forEach { flavor ->
            create(flavor) {
                dimension = "api"
                applicationIdSuffix = if (flavor != mainFlavour) ".${flavor}" else ""
                versionNameSuffix = if (flavor != mainFlavour) "-${flavor}" else ""
                manifestPlaceholders["host"] = localProperties.getProperty("host_${flavor}")
                manifestPlaceholders["fb_app_id"] =
                    localProperties.getProperty("fb_app_id_${flavor}").replace("\"", "")
                manifestPlaceholders["fb_client_token"] =
                    localProperties.getProperty("fb_client_token_${flavor}").replace("\"", "")
                buildConfigField(
                    "String",
                    "FB_APP_ID",
                    localProperties.getProperty("fb_app_id_${flavor}")
                )
                buildConfigField(
                    "String",
                    "GOOGLE_WEB_CLIENT_ID",
                    localProperties.getProperty("google_web_client_id_${flavor}")
                )
                buildConfigField(
                    "String",
                    "AUTH_SERVER",
                    localProperties.getProperty("auth_server_${flavor}")
                )
                buildConfigField(
                    "String",
                    "ONESIGNAL_APP_ID",
                    localProperties.getProperty("onesignal_app_id_${flavor}")
                )
                resValue(
                    "string",
                    "app_name",
                    "${appName}${if (flavor != mainFlavour) " (${flavor.uppercase()})" else ""}"
                )
                resValue(
                    "string",
                    "app_version",
                    String.format("%s%s", "${defaultConfig.versionName}", "${versionNameSuffix}")
                )
            }
        }
    }
}

dependencies {
    implementation(project(":auth_shared"))
    implementation(libs.onesignal)
    testImplementation(libs.junit)
}