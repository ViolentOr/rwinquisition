package me.violentor.rwinquisition.web.handler

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component
class ServiceHandler {

    fun ping(request: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject("{\"code\":\"0, \"message\":\"pong\"}"))
    }
}