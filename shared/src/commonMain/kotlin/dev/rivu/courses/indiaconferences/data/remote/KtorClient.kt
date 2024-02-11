package dev.rivu.courses.indiaconferences.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpRequestRetry.Configuration
import kotlinx.serialization.json.Json


expect val KtorClient: HttpClient


val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
}

fun Configuration.retryConfig() {
    retryOnServerErrors(maxRetries = 3)
    exponentialDelay()
}