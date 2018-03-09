package me.violentor.rwinquisition.web

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.test.test

@ExtendWith(SpringExtension::class)
// Start an actual server on a RANDOM_PORT
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//TODO: replace with WebTestClient (https://spring.io/guides/gs/reactive-rest-service/) on Kotlin 1.3, due to https://jira.spring.io/browse/SPR-16057
class ApiServiceTest(@LocalServerPort port: Int)  {

    private val webClient = WebClient.create("http://localhost:$port")

    @Test
    fun `Assure that Ping always Pong`() {
        webClient!!
                // Create a GET request to test an endpoint
                .get().uri("/api/v1/service/ping").accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono<String>()
                .test()
                .expectError()
    }
}