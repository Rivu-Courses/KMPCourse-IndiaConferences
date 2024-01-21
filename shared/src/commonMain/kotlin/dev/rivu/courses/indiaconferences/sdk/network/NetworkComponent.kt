package dev.rivu.courses.indiaconferences.sdk.network

import io.ktor.client.HttpClient
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides


@Component
abstract class NetworkComponent {
    @Provides
    fun getKtorClient(): HttpClient = KtorClient

    @Provides
    fun getUsersUrl(): String = "https://jsonplaceholder.typicode.com/users"
}