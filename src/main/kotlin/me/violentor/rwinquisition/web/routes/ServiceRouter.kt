//Reference project https://github.com/mixitconf/mixit/blob/master/src/main/kotlin/mixit/web/routes/ApiRoutes.kt

package me.violentor.rwinquisition.web.routes

import me.violentor.rwinquisition.web.handler.ServiceHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.*


@Configuration
class GreetingRouter(private val serviceHandler: ServiceHandler) {

    @Bean
    fun apiServiceRouter() = router {
        (accept(APPLICATION_JSON) and "/api/v1/service").nest {
            "/ping".nest {
                GET("/", serviceHandler::ping)
            }
        }
    }
}