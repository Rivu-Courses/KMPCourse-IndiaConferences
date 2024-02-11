package dev.rivu.courses.indiaconferences.remote

import android.util.Log
import dev.rivu.courses.indiaconferences.data.remote.json
import dev.rivu.courses.indiaconferences.data.remote.retryConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import isDebug
import okhttp3.internal.platform.android.AndroidLogHandler.setLevel
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
            json
        }

        install(HttpRequestRetry) {
            retryConfig()
        }
    }
}