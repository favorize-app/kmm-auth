plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "web-example.js"
            }
        }
        binaries.executable()
    }
    
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "web-example-wasm.js"
            }
        }
        binaries.executable()
    }
    
    sourceSets {
        jsMain {
            dependencies {
                implementation(project(":auth_shared"))
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
            }
        }
        
        wasmJsMain {
            dependencies {
                implementation(project(":auth_shared"))
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
            }
        }
    }
}
