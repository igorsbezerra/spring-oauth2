package dev.igor.client_service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.OAuth2ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Bean
    RestClient keycloakRestClient(RestClient.Builder builder, OAuth2AuthorizedClientManager authorizedClientManager) {
        var requestInterceptor = new OAuth2ClientHttpRequestInterceptor(authorizedClientManager);
        requestInterceptor.setClientRegistrationIdResolver((HttpRequest request) -> "client-service");
        return builder.
            requestInterceptor(requestInterceptor)
            .build();
    }
}
