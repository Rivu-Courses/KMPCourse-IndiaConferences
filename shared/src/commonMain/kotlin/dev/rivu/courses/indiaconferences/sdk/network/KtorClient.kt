package dev.rivu.courses.indiaconferences.sdk.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.serialization.Configuration
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect val KtorClient: HttpClient

val baseUrl = "https://jsonplaceholder.typicode.com/"

fun Configuration.jsonContentNegotiation() = Json {
    ignoreUnknownKeys = true
    isLenient = true
}

fun HttpRequestRetry.Configuration.retryConfig() {
    retryOnServerErrors(maxRetries = 3)
    exponentialDelay()
}