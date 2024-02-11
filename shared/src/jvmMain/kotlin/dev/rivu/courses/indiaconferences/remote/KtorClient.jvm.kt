package dev.rivu.courses.indiaconferences.remote

import io.ktor.client.HttpClient

actual val KtorClient: HttpClient
    get() = HttpClient()