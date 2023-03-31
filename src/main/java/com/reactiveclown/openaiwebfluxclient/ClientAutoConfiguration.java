package com.reactiveclown.openaiwebfluxclient;

import com.reactiveclown.openaiwebfluxclient.client.audio.AudioService;
import com.reactiveclown.openaiwebfluxclient.client.audio.AudioServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.chat.ChatService;
import com.reactiveclown.openaiwebfluxclient.client.chat.ChatServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.completions.CompletionsService;
import com.reactiveclown.openaiwebfluxclient.client.completions.CompletionsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.edits.EditsService;
import com.reactiveclown.openaiwebfluxclient.client.edits.EditsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.embeddings.EmbeddingsService;
import com.reactiveclown.openaiwebfluxclient.client.embeddings.EmbeddingsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.files.FilesService;
import com.reactiveclown.openaiwebfluxclient.client.files.FilesServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.finetunes.FineTuneServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.finetunes.FineTunesService;
import com.reactiveclown.openaiwebfluxclient.client.images.ImageServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.images.ImagesService;
import com.reactiveclown.openaiwebfluxclient.client.models.ModelsService;
import com.reactiveclown.openaiwebfluxclient.client.models.ModelsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.client.moderations.ModerationsService;
import com.reactiveclown.openaiwebfluxclient.client.moderations.ModerationsServiceImpl;
import com.reactiveclown.openaiwebfluxclient.exception.OpenAiException;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("OpenAIClient")
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
    public AudioService audioService(@Qualifier("OpenAIClient") WebClient client) {
        return new AudioServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public ChatService chatService(@Qualifier("OpenAIClient") WebClient client) {
        return new ChatServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public CompletionsService completionsService(@Qualifier("OpenAIClient") WebClient client) {
        return new CompletionsServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public EditsService editsService(@Qualifier("OpenAIClient") WebClient client) {
        return new EditsServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public EmbeddingsService embeddingsService(@Qualifier("OpenAIClient") WebClient client) {
        return new EmbeddingsServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public FilesService filesService(@Qualifier("OpenAIClient") WebClient client) {
        return new FilesServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public FineTunesService fineTunesService(@Qualifier("OpenAIClient") WebClient client) {
        return new FineTuneServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public ImagesService imagesService(@Qualifier("OpenAIClient") WebClient client) {
        return new ImageServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public ModelsService modelsService(@Qualifier("OpenAIClient") WebClient client) {
        return new ModelsServiceImpl(client);
    }

    @Bean
    @ConditionalOnMissingBean
    public ModerationsService moderationsService(@Qualifier("OpenAIClient") WebClient client){
        return new ModerationsServiceImpl(client);
    }
}
