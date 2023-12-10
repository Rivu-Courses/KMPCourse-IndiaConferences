import extensions.getLocalProperty
import org.jetbrains.gradle.ext.settings
import org.jetbrains.gradle.ext.taskTriggers


// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:${libs.versions.atomicfu.get()}")
    }
}
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.wire) apply false
    kotlin("plugin.serialization") version libs.versions.kotlin.get() apply false
    alias(libs.plugins.spotless) apply false
    id("org.jetbrains.gradle.plugin.idea-ext") version libs.versions.ideaGradlePluginExtension.get()
    alias(libs.plugins.kmmbridge) apply false
    id("co.touchlab.skie") version "0.4.18" apply false
    alias(libs.plugins.sqlDelight) apply false
}

subprojects {

    apply(plugin = "com.diffplug.spotless")
    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            targetExclude("**/generated-sources/**")
            ktlint(libs.versions.ktlint.get())
        }
    }

    apply(plugin = "maven-publish")
    configure<PublishingExtension> {
        repositories {
            maven {
                name = "jfrog"
                url = uri("https://store-stage.v18cc.com/artifactory/libs-release")
                credentials {
                    username = getLocalProperty("jfrogUploadUsername")
                    password = getLocalProperty("jfrogUploadPassword")
                }
            }
        }
    }
}

