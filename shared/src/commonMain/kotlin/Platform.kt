interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

fun isDebug(): Boolean = true