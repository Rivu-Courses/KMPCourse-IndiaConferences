package dev.rivu.courses.indiaconferences.sdk.network

import android.util.Log
import dev.rivu.courses.indiaconferences.sdk.isDebug
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.serialization.kotlinx.protobuf.protobuf
import kotlinx.serialization.json.Json
import okhttp3.logging.HttpLoggingInterceptor

actual val KtorClient: HttpClient by lazy {
    Log.d("SDK","KtorClient Android")

    HttpClient(OkHttp) {
        // default validation to throw exceptions for non-2xx responses
        expectSuccess = true

        engine {
            // add logging interceptor
            if (isDebug()) {
                addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(
                            HttpLoggingInterceptor.Level.BODY,
                        )
                    },
                )
            }
        }

        install(ContentNegotiation) {
            // protobuf()
            jsonContentNegotiation()
        }

        install(HttpRequestRetry) {
            retryConfig()
        }
    }
}