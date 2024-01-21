import co.touchlab.skie.configuration.DefaultArgumentInterop
import co.touchlab.skie.configuration.EnumInterop
import co.touchlab.skie.configuration.FlowInterop
import co.touchlab.skie.configuration.SealedInterop
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    //id("co.touchlab.faktory.kmmbridge")
    id("co.touchlab.skie")
    id("app.cash.sqldelight")
    `maven-publish`
}


skie {
    features {
        group {
            FlowInterop.Enabled(true)
        }
        group("co.touchlab.skie.types") {
            SealedInterop.Enabled(true)
            EnumInterop.Enabled(true)
            DefaultArgumentInterop.Enabled(true)
        }
    }
}

sqldelight {
    databases {
        create("IndiaConfDB") {
            packageName.set("dev.rivu.courses.indiaconferences.sdk.db")
        }
    }
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        publishLibraryVariants("release", "debug")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    val xcFramework = XCFramework("IndiaConferences")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        tvosArm64(),
        tvosX64(),
        tvosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            xcFramework.add(this)
            baseName = "IndiaConferences"
        }
    }

    js(IR) {
        moduleName = "@rivucourses/${SDKConfig.sdkName}"
        version = LibraryConfig.version
        nodejs()
        browser {
            binaries.executable()
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.bundles.common.ktor)
                implementation(libs.coroutines.core)
                implementation(libs.kotlinx.datetime)

                implementation(libs.koin.core)
                implementation(libs.skie)
                implementation(libs.kmpSettings.core)
                implementation(libs.kmpSettings.noArg)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.koin.test)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(npm("uuid", "9.0.0"))
                implementation(libs.wire.runtime.js)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.okHttp)

                implementation(libs.okhttp.loggingInterceptor)
                implementation(libs.koin.android)
                implementation(libs.sqlDelight.android)
            }
        }

        val nativeMain by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
                implementation(libs.sqlDelight.native)
            }
        }

        val tvosMain by getting {
            dependencies {
                dependsOn(nativeMain)
            }
        }

        val iosMain by getting {
            dependencies {
                dependsOn(nativeMain)
            }
        }
    }
}

android {
    namespace = "dev.rivu.courses.indiaconferences.sdk"
    compileSdk = SDKConfig.Android.compileSdk
    defaultConfig {
        minSdk = SDKConfig.Android.minSdk
    }
}

publishing {
    afterEvaluate {
        publications {
            withType<MavenPublication> {
                groupId = LibraryConfig.groupId
                artifactId = LibraryConfig.artifactIdSdk
                version = LibraryConfig.version
            }
        }
    }
}