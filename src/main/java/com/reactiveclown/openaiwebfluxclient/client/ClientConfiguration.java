package com.reactiveclown.openaiwebfluxclient.client;

import com.reactiveclown.openaiwebfluxclient.client.completions.CompletionsService;
import com.reactiveclown.openaiwebfluxclient.client.completions.CompletionsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.images.ImageServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.images.ImagesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AutoConfiguration
public class ClientConfiguration {

    @Value("${openai.api.baseUrl:https://api.openai.com/v1}")
    private String baseUrl;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${opeanai.api.organizationId:#{null}}")
    private String organizationId;

    @Bean
    public WebClient webClient() {
        if (organizationId == null) {
            return WebClient.builder()
                    .baseUrl(baseUrl)
                    .defaultHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", apiKey))
                    .build();
        }

        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", apiKey));
                    httpHeaders.add("OpenAI-Organization", organizationId);
                })
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public ImagesService imagesService(WebClient client){
        return new ImageServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public CompletionsService completionsService(WebClient client){
        return new CompletionsServiceImpl(client);
    }
}
