package com.reactiveclown.openaiwebfluxclient.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {

    @Value("${openai.api.baseUrl:https://api.openai.com/v1}")
    private String baseUrl;

    @Value("${openai.api.key}")
    private String apiKey;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", String.format("Bearer %s", apiKey))
                .build();
    }
}
