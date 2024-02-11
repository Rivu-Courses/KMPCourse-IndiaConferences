import dev.rivu.courses.indiaconferences.remote.KtorClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun getResponseFromServer(): String {
        val response = KtorClient.get("http://0.0.0.0:8080")
        return response.bodyAsText()
    }
}