package dev.rivu.courses.indiaconferences.sdk

import platform.Foundation.NSUUID
import kotlin.native.Platform as NativePlatform

actual fun getPlatform(): Platform = Platform

actual fun getRandomUUID(): String = NSUUID().UUIDString()
actual fun isDebug(): Boolean = NativePlatform.isDebugBinary
actual typealias NumericLongType = Long