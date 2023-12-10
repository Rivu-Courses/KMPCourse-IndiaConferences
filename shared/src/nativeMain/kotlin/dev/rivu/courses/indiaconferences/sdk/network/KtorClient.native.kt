package dev.rivu.courses.indiaconferences.sdk.network

import dev.rivu.courses.indiaconferences.sdk.isDebug
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import io.ktor.serialization.kotlinx.protobuf.protobuf
import kotlinx.serialization.json.Json

actual val KtorClient: HttpClient by lazy {
    HttpClient(Darwin) {
        // default validation to throw exceptions for non-2xx responses
        expectSuccess = true

        if (isDebug()) {
            install(Logging) {
                level = LogLevel.ALL
            }
        }

        engine {
            configureRequest {
                setAllowsCellularAccess(true)
                setAllowsExpensiveNetworkAccess(true)
            }
        }

        install(ContentNegotiation) {
            jsonContentNegotiation()
        }

        install(HttpRequestRetry) {
            retryOnServerErrors(maxRetries = 3)
            exponentialDelay()
        }
    }
}

