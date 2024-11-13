import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.coroutines.runBlocking


// Define request and response data classes
@Serializable
data class OllamaRequest(
    val model: String = "default_model", //
    val prompt: String
)

@Serializable
data class OllamaResponse(
    val text: String
)

fun main() = runBlocking {
    // Initialize the HTTP client with content negotiation
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    // Send a POST request to the local Ollama server
    val response = client.post("http://localhost:11434/completions") {
        contentType(ContentType.Application.Json)
        setBody(OllamaRequest(prompt = "Hello, world!"))
    }

    // Extract the response body
    val result: OllamaResponse = response.body()
    println("Response from Ollama model: ${result.text}")

    // Close the client
    client.close()
}
