package dev.rivu.courses.indiaconferences.sdk.network

import dev.rivu.courses.indiaconferences.sdk.getPlatform
import dev.rivu.courses.indiaconferences.sdk.network.models.UsersResponseItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import me.tatarka.inject.annotations.Inject

@Inject
class UsersApi(
    private val client: HttpClient,
    private val url: String,
) {
    suspend fun getUsers(): List<UsersResponseItem> {
        val response = client.get(url)

        return if (response.status.value in 200..202) {
            //success
            val responseStr = response.bodyAsText()
            return json.decodeFromString(responseStr)
        } else {
            throw RuntimeException(response.bodyAsText())
        }
    }

    fun printPlatformNameInConsole() {
        val platform = getPlatform()
        println(platform.name)
    }
}