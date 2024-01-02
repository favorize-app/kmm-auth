@file:Suppress("UnstableApiUsage", "DataBindingWithoutKapt")

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toUpperCaseAsciiOnly

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.gms)
    alias(libs.plugins.crashlytics)
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
val localProperties = gradleLocalProperties(rootDir)

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }

    flavorDimensions += "api"
    productFlavors {
        val mainFlavour = localProperties.getProperty("mainFlavor")
        val flavours = localProperties.getProperty("flavors").split(",")
        flavours.forEach {
            create(it) {
                dimension = "api"
                applicationIdSuffix = if (it != mainFlavour) ".${it}" else ""
                versionNameSuffix = if (it != mainFlavour) "-${it}" else ""
                manifestPlaceholders["fb_app_id"] =
                    localProperties.getProperty("fb_app_id_${it}").replace("\"", "")
                manifestPlaceholders["fb_client_token"] =
                    localProperties.getProperty("fb_client_token_${it}").replace("\"", "")
                buildConfigField(
                    "String",
                    "FB_APP_ID",
                    localProperties.getProperty("fb_app_id_${it}")
                )
                buildConfigField(
                    "String",
                    "GOOGLE_WEB_CLIENT_ID",
                    localProperties.getProperty("google_web_client_id_${it}")
                )
                buildConfigField(
                    "String",
                    "AUTH_SERVER",
                    localProperties.getProperty("auth_server_${it}")
                )
                buildConfigField(
                    "String",
                    "ONESIGNAL_APP_ID",
                    localProperties.getProperty("onesignal_app_id_${it}")
                )
                resValue(
                    "string",
                    "app_name",
                    "${appName}${if (it != mainFlavour) " (${it.toUpperCaseAsciiOnly()})" else ""}"
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
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.crashlytics)
    testImplementation(libs.junit)
}