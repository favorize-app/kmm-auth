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
    alias(libs.plugins.crashlytics).apply(false)
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
        "excs", mutableListOf(
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
            "*BR",
            "**/Manifest*.*",
            "**/*Lambda$*.*",
            "*ActualKt",
            "*Format",
            "*Adapter",
            "*Payload",
            "*Payload\$*",
            "*Response",
            "*Response\$*",
            "*ViewHolder",
            "*ViewHolder\$*",
            "*KoinKt",
            "*KoinKt\$*",
            "*Platform",
            "*Application",
            "*Application\$*",
            "*Fragment",
            "*Fragment\$*",
            "*Activity",
            "*Activity\$*",
            "*Adapters",
            "*Adapters\$*",
            "*Listener",
            "*Listener\$*",
            "*Repository",
            "*Repository\$*",
            "*Impl",
            "*Impl\$*",
            "*Serializer",
            "*Serializer\$*",
            "*Config",
            "*Config\$*",
            "*Key",
            "*Key\$*",
            "*Module",
            "*Module\$*",
            "*.databinding.*",
            "*DataBinding*",
            "*.BuildConfig",
            "*.entity.*",
            "*.constants.*",
            "*.enums.*",
            "*.extensions.*",
        )
    )
}

sonar {
    val excs: MutableList<String> by extra
    properties {
        property("sonar.projectKey", "kotlin-multi-platform-core")
        property("sonar.projectName", "kotlin-multi-platform-core")
        property("sonar.token", localProperties.getProperty("sonarqubeToken"))
        property("sonar.host.url", localProperties.getProperty("sonarqubeHost"))
        property("sonar.exclusions", excs.joinToString(","))
        property("sonar.coverage.jacoco.xmlReportPaths", "core_shared/build/reports/kover/report.xml")
        property("sonar.coverage.exclusions", excs.joinToString(", "))
    }
}

tasks.sonar.dependsOn("koverXmlReport")

tasks.register("buildVersionName") {
    description = "Generate version name"
    group = LifecycleBasePlugin.BUILD_TASK_NAME
    val appVersionName: String by project
    println(appVersionName)
}

tasks.register("installGitHooks", Exec::class) {
    description = "Install git hooks pre-commit"
    group = LifecycleBasePlugin.CHECK_TASK_NAME
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