package com.reactiveclown.openaiwebfluxclient.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AsynchronousConfiguration {

    @Bean
    public WebClient webClient() {
        String baseUrl = "https://api.openai.com/v1";
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer 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")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
