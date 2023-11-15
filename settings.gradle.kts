pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://gitlab.com/api/v4/projects/38836420/packages/maven")
    }
}
rootProject.name = "Auth"
include(":example_android")
include(":auth_shared")
