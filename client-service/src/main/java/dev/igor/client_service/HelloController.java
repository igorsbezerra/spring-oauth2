package dev.igor.client_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("client")
public class HelloController {

    private final RestClient keycloakRestClient;

    public HelloController(RestClient keycloakRestClient) {
        this.keycloakRestClient = keycloakRestClient;
    }

    @GetMapping("hello")
    public String hello() {
        return keycloakRestClient.get()
            .uri("http://localhost:8000/hello")
            .retrieve()
            .body(String.class);
    }
}
