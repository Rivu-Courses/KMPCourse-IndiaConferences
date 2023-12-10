package dev.rivu.courses.indiaconferences.sdk

import kotlinx.serialization.Serializable

actual object Platform {
    actual val name: String = "NodeJS"
}

actual fun getPlatform(): Platform {
    return Platform
}

actual fun getRandomUUID(): String = uuid.v4().toString()
actual fun isDebug(): Boolean = true

actual typealias NumericLongType = Int