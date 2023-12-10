package dev.rivu.courses.indiaconferences.sdk.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual val KtorClient: HttpClient by lazy {
    HttpClient() {
        install(ContentNegotiation) {
            // protobuf()
            json(
                jsonContentNegotiation()
            )
        }

        Logging {

        }
    }
}