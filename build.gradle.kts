import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.navigation).apply(false)
    alias(libs.plugins.dokka)
    alias(libs.plugins.gms).apply(false)
    alias(libs.plugins.sonarqube)
    alias(libs.plugins.kover)
    alias(libs.plugins.spotless)
}
apply(from = "$rootDir/auth-module.gradle")

dependencies {
    kover(project(":auth_shared"))
}

val localProperties = gradleLocalProperties(rootDir)

extra.apply {
    set(
        "excludes", mutableListOf(
            "**/*ViewHolder.*",
            "**/*BottomSheet.*",
            "**/*BottomSheet*",
            "**/*Dialog.*",
            "**/*Adapter.*",
            "**/*_ViewBinding.*",
            "**/*Activity.*",
            "**/*Fragment.*",
            "**/databinding/*Binding.*",
            "**/databinding/*Binding*",
            "**/R.class",
            "**/R$*.class",
            "**/BuildConfig.*",
            "**/Manifest*.*",
            "**/*Test*.*",
            "android/**/*.*",
            // kotlin
            "**/*MapperImpl*.*",
            "**/*ViewInjector*.*",
            "**/*ViewBinder*.*",
            "**/BuildConfig.*",
            "**/*Component*.*",
            "**/*BR*.*",
            "**/Manifest*.*",
            "**/*Lambda$*.*",
            "**/*Companion*.*",
            "**/*Module*.*",
            "**/*Dagger*.*",
            "**/*Hilt*.*",
            "**/*MembersInjector*.*",
            "**/*_MembersInjector.class",
            "**/*_Factory*.*",
            "**/*_Provide*Factory*.*",
            "**/*Extensions*.*"
        )
    )
}

sonar {
    val excludes: MutableList<String> by extra
    properties {
        property("sonar.projectKey", "kotlin-multi-platform-core")
        property("sonar.projectName", "kotlin-multi-platform-core")
        property("sonar.token", localProperties.getProperty("sonarqubeToken"))
        property("sonar.host.url", localProperties.getProperty("sonarqubeHost"))
        property("sonar.exclusions", excludes.joinToString(","))
        property("sonar.coverage.jacoco.xmlReportPaths", "core_shared/build/reports/kover/report.xml")
        property("sonar.coverage.exclusions", excludes.joinToString(", "))
    }
}

tasks.sonar.dependsOn("koverXmlReport")

tasks.register("buildVersionName") {
    val appVersionName: String by project
    println(appVersionName)
}

tasks.register("installGitHooks", Exec::class) {
    commandLine("./scripts/install-git-hooks.sh")
}

tasks.prepareKotlinBuildScriptModel.dependsOn("installGitHooks")

subprojects {
    apply(plugin = rootProject.libs.plugins.dokka.get().pluginId)
    afterEvaluate {
        project.apply("../spotless.gradle")
    }
    tasks.dokkaGfm {
        outputDirectory.set(rootProject.rootDir.resolve("docs"))
    }
}