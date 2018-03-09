package me.violentor.rwinquisition

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User


@EnableWebFluxSecurity
class HelloWebfluxSecurityConfig {

    @Bean
    // TODO: Yeah, this is really bad. Should be redone be4 using
    fun userDetailsService(): MapReactiveUserDetailsService {
        val user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build()
        return MapReactiveUserDetailsService(user)
    }
}