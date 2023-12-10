package dev.rivu.courses.indiaconferences.sdk.network

import dev.rivu.courses.indiaconferences.sdk.network.models.UsersResponseItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class UsersApi(private val client: HttpClient) {
    suspend fun getUsers(): List<UsersResponseItem> {
        val response = client.get("https://jsonplaceholder.typicode.com/users")

        return if (response.status.value in 200..202) {
            //success
            response.body<List<UsersResponseItem>>()
        } else {
            throw RuntimeException(response.bodyAsText())
        }
    }
}