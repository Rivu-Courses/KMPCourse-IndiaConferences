import org.jetbrains.kotlin.gradle.plugin.sources.dependsOnClosure
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.sqlDelight)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    /*@OptIn(ExperimentalWasmDsl::class)
    wasmJs {
       browser()
    }*/
    applyDefaultHierarchyTemplate()
    
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    
    jvm()
    
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.common.ktor.client)
            implementation(libs.coroutines.core)
            implementation(libs.arrow.core)
            implementation(libs.kotlinInject.runtime)
        }

        androidMain.dependencies {
            implementation(libs.sqlDelight.android)
            implementation(libs.ktor.client.okHttp)
            implementation(libs.okhttp.loggingInterceptor)
        }

        // or iosMain, windowsMain, etc.
        nativeMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.sqlDelight.native)
        }

        jvmMain.dependencies {
            implementation(libs.sqlDelight.jvm)
        }
    }
}

android {
    namespace = "dev.rivu.courses.indiaconferences.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

dependencies {
    // KSP will eventually have better multiplatform support and we'll be able to simply have
    // `ksp libs.kotlinInject.compiler` in the dependencies block of each source set
    // https://github.com/google/ksp/pull/1021
    add("kspIosX64", libs.kotlinInject.compiler)
    add("kspIosArm64", libs.kotlinInject.compiler)
    add("kspIosSimulatorArm64", libs.kotlinInject.compiler)
    add("kspAndroid", libs.kotlinInject.compiler)
}
