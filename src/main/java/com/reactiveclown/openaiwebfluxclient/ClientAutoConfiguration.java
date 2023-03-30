package com.reactiveclown.openaiwebfluxclient;

import com.reactiveclown.openaiwebfluxclient.client.completions.CompletionsService;
import com.reactiveclown.openaiwebfluxclient.client.completions.CompletionsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.images.ImageServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.images.ImagesService;
import com.reactiveclown.openaiwebfluxclient.client.models.ModelsService;
import com.reactiveclown.openaiwebfluxclient.client.models.ModelsServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AutoConfiguration
@EnableConfigurationProperties(ClientAutoConfigurationProperties.class)
public class ClientAutoConfiguration {

    private final ClientAutoConfigurationProperties properties;

    public ClientAutoConfiguration(ClientAutoConfigurationProperties properties) {
        this.properties = properties;
    }

    @Bean
    public WebClient webClient() {
        if (properties.organizationId() == null) {
            return WebClient.builder()
                    .baseUrl(properties.baseUrl())
                    .defaultHeader(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", properties.apiKey()))
                    .build();
        }

        return WebClient.builder()
                .baseUrl(properties.baseUrl())
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, String.format("Bearer %s",properties.apiKey()));
                    httpHeaders.add("OpenAI-Organization", properties.organizationId());
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

    @Bean
    @ConditionalOnMissingBean
    public ModelsService modelsService(WebClient client) {
        return new ModelsServiceImpl(client);
    }
}
