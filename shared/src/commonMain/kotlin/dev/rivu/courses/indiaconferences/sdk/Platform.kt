package dev.rivu.courses.indiaconferences.sdk

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

expect object Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun getRandomUUID(): String

expect fun isDebug(): Boolean

fun getCurrentTimeStamp(): Instant = Clock.System.now()

expect class NumericLongType
