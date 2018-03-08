package me.violentor.rwinquisition.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController{

    @GetMapping("/ping")
    fun ping() = "{\"code\":\"0, \"message\":\"pong\"}"
}
