@file:Suppress("UnstableApiUsage", "DataBindingWithoutKapt")
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toUpperCaseAsciiOnly

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.gms)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlinx-serialization")
}

val repoId: String by project
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
                resValue(
                    "string",
                    "app_name",
                    "Auth${if (it != mainFlavour) " (${it.toUpperCaseAsciiOnly()})" else ""}"
                )
                resValue(
                    "string",
                    "app_version",
                    String.format("%s%s", "${defaultConfig.versionName}", "${versionNameSuffix}")
                )
                resValue(
                    "string", "route_profile_full",
                    localProperties.getProperty("scheme") + (if (it != mainFlavour) "-$it" else "") + "://" +
                            localProperties.getProperty("host") + "/profile"
                )
                resValue(
                    "string",
                    "route_profile",
                    localProperties.getProperty("host") + "/profile"
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
    testImplementation(libs.junit)
}