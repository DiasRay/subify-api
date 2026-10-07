package com.subify.subify_api.infrastructure.adapter.input.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/ping")
    public String ping() {
        return "Subify API está rodando!";
    }
}