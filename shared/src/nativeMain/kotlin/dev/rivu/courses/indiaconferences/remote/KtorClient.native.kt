package dev.rivu.courses.indiaconferences.remote

import dev.rivu.courses.indiaconferences.data.remote.json
import dev.rivu.courses.indiaconferences.data.remote.retryConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import isDebug

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
            json
        }

        install(HttpRequestRetry) {
            retryConfig()
        }
    }
}