package com.reactiveclown.openaiwebfluxclient;

import com.reactiveclown.openaiwebfluxclient.client.completions.CompletionsService;
import com.reactiveclown.openaiwebfluxclient.client.completions.CompletionsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.images.ImageServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.images.ImagesService;
import com.reactiveclown.openaiwebfluxclient.client.models.ModelsService;
import com.reactiveclown.openaiwebfluxclient.client.models.ModelsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.exception.OpenAiException;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
@AutoConfiguration
@EnableConfigurationProperties(ClientAutoConfigurationProperties.class)
public class ClientAutoConfiguration {


    private final ClientAutoConfigurationProperties properties;

    public ClientAutoConfiguration(ClientAutoConfigurationProperties properties) {
        this.properties = properties;
    }

    public ExchangeFilterFunction errorHandlerExchangeFilterFunction() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            if (clientResponse.statusCode().isError()) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorMessage -> Mono.error(
                                new OpenAiException(clientResponse.statusCode().value(),
                                        errorMessage)));
            }
            return Mono.just(clientResponse);
        });
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(properties.baseUrl())
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.AUTHORIZATION, String.format("Bearer %s", properties.apiKey()));
                    if (properties.organizationId() != null)
                        httpHeaders.add("OpenAI-Organization", properties.organizationId());
                })
                .filter(errorHandlerExchangeFilterFunction())
                .build();
    }


    @Bean
    @ConditionalOnMissingBean
    public ImagesService imagesService(WebClient client) {
        return new ImageServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public CompletionsService completionsService(WebClient client) {
        return new CompletionsServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public ModelsService modelsService(WebClient client) {
        return new ModelsServiceImpl(client);
    }
}
