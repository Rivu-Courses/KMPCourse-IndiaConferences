package dev.rivu.courses.indiaconferences.sdk.network

import dev.rivu.courses.indiaconferences.sdk.getPlatform
import dev.rivu.courses.indiaconferences.sdk.network.models.UsersResponseItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class UsersApi(
    private val client: HttpClient,
    private val url: String,
) {
    suspend fun getUsers(): List<UsersResponseItem> {
        val response = client.get(url)

        return if (response.status.value in 200..202) {
            //success
            response.body<List<UsersResponseItem>>()
        } else {
            throw RuntimeException(response.bodyAsText())
        }
    }

    fun printPlatformNameInConsole() {
        val platform = getPlatform()
        println(platform.name)
    }
}