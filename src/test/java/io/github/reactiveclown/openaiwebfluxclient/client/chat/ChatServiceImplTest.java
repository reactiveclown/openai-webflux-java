package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.reactiveclown.openaiwebfluxclient.client.UsageData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChatServiceImplTest {


    @Mock
    WebClient.RequestBodyUriSpec requestBodyUriSpec;
    @Mock
    WebClient.RequestBodySpec requestBodySpec;
    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpec;
    @Mock
    WebClient.ResponseSpec responseSpec;
    @Mock
    private WebClient webClient;

    private ObjectMapper objectMapper;

    @InjectMocks
    private ChatServiceImpl chatService;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        ReflectionTestUtils.setField(chatService, "objectMapper", objectMapper);
    }

    @Test
    public void createChatCompletion() {
        // Arrange
        CreateChatCompletionRequest request = CreateChatCompletionRequest
                .builder(
                        "model",
                        List.of(new MessageData(
                                "role",
                                "content")))
                .stream(true)
                .build();
        CreateChatCompletionResponse expectedResponse = new CreateChatCompletionResponse(
                "id",
                "object",
                1L,
                "model",
                List.of(new ChoiceData(
                        1,
                        null,
                        new MessageData(
                                "role",
                                "content"),
                        "finishReason")),
                new UsageData(
                        1,
                        1,
                        2));
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(CreateChatCompletionResponse.class)).thenReturn(Mono.just(expectedResponse));

        // Assert
        StepVerifier.create(chatService.createChatCompletion(request))
                .expectNext(expectedResponse)
                .verifyComplete();
    }

    @Test
    public void createStreamChatCompletion() {
        // Arrange
        CreateChatCompletionRequest request = CreateChatCompletionRequest
                .builder(
                        "model",
                        List.of(new MessageData(
                                "role",
                                "content")))
                .stream(true)
                .build();
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.accept(any(MediaType.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(any())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);

        // case [DONE]
        ServerSentEvent<String> mockEvent = ServerSentEvent.builder("[DONE]").build();
        Flux<ServerSentEvent<String>> responseFlux = Flux.just(mockEvent);
        when(responseSpec.bodyToFlux(new ParameterizedTypeReference<ServerSentEvent<String>>() {
        }))
                .thenReturn(responseFlux);

        // Assert
        StepVerifier.create(chatService.createStreamChatCompletion(request))
                .expectNextCount(0) // Since the data is "[DONE]", it should return an empty flux
                .verifyComplete();

        // case delta
        mockEvent = ServerSentEvent.builder("""
                {
                    "id": "chatcmpl-mock",
                    "object": "chat.completion.chunk",
                    "created": 1703257917,
                    "model": "gpt-3.5-turbo-0613",
                    "system_fingerprint": null,
                    "choices": [
                        {
                            "index": 0,
                            "delta": {
                                "content": "mock"
                            },
                            "logprobs": null,
                            "finish_reason": null
                        }
                    ]
                }""").build();
        responseFlux = Flux.just(mockEvent);
        when(responseSpec.bodyToFlux(new ParameterizedTypeReference<ServerSentEvent<String>>() {
        }))
                .thenReturn(responseFlux);

        // Assert
        StepVerifier.create(chatService.createStreamChatCompletion(request))
                .expectNextMatches(chatCompletionChunk -> chatCompletionChunk.choices().get(0).message().content().equals("mock"))
                .verifyComplete();
    }
}