package com.reactiveclown.openaiwebfluxclient.asynchronous;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AsynchronousConfiguration {

    @Bean
    public WebClient webClient(ObjectMapper baseConfig) {
        ObjectMapper newMapper = baseConfig.copy();
        newMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        String baseUrl = "https://api.openai.com/v1";


        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Bearer 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")
                .build();
    }
}
