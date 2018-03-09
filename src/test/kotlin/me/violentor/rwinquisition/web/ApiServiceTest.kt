package me.violentor.rwinquisition.web

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.util.Base64Utils
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.test.test
import kotlin.text.Charsets.UTF_8


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//TODO: replace with WebTestClient (https://spring.io/guides/gs/reactive-rest-service/) on Kotlin 1.3, due to https://jira.spring.io/browse/SPR-16057
internal class ApiServiceTest(@LocalServerPort port: Int){

    private val client = WebClient.create("http://localhost:$port")

    @Test
    fun `No access without authentication`() {
        client.get().uri("/api/v1/service/ping").accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono<String>()
                .test()
                .expectError()
    }

    @Test
    fun `Ping Pongs with right password`() {
        client.get().uri("/api/v1/service/ping").accept(APPLICATION_JSON)
                .header("Authorization", "Basic " + Base64Utils
                        .encodeToString(("user:user").toByteArray(UTF_8)))
                .retrieve()
                .bodyToMono<String>()
                .test()
                .consumeNextWith { assertEquals("{\"code\":\"0, \"message\":\"pong\"}", it) }
                .verifyComplete()
    }
}