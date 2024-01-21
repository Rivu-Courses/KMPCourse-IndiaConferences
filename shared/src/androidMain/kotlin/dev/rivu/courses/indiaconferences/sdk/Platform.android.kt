package dev.rivu.courses.indiaconferences.sdk

import java.util.UUID
import dev.rivu.courses.indiaconferences.sdk.BuildConfig
import okhttp3.internal.platform.AndroidPlatform

actual object Platform {
    actual val name: String = "Android"
}

actual fun getPlatform(): Platform = Platform
actual fun getRandomUUID(): String = UUID.randomUUID().toString()
actual fun isDebug(): Boolean = BuildConfig.DEBUG
actual typealias NumericLongType = Long