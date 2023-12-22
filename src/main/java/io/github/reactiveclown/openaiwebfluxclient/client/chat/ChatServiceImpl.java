package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ChatServiceImpl implements ChatService{

    private final WebClient client;
    private final ObjectMapper objectMapper;
    private static final String CREATE_CHAT_COMPLETION_URL = "/chat/completions";
    public ChatServiceImpl(WebClient client, ObjectMapper objectMapper){
        this.client = client;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<CreateChatCompletionResponse> createChatCompletion(CreateChatCompletionRequest request) {
        return client.post()
                .uri(CREATE_CHAT_COMPLETION_URL)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateChatCompletionResponse.class);
    }

    @Override
    public Flux<ChatCompletionChunk> createStreamChatCompletion(CreateChatCompletionRequest request) {
        if (request.stream() == null || !request.stream()) {
            request = request.withStream();
        }
        return client.post()
                .uri(CREATE_CHAT_COMPLETION_URL)
                .accept(MediaType.TEXT_EVENT_STREAM)
                .bodyValue(request)
                .retrieve()
                // transfer to String first to handle the "[DONE]"
                .bodyToFlux(new ParameterizedTypeReference<ServerSentEvent<String>>() {
                })
                .flatMap(serverSentEvent -> {
                    String data = serverSentEvent.data();
                    // ignore the done text
                    if (data == null || data.equals("[DONE]")) {
                        return Mono.empty();
                    }
                    try {
                        ChatCompletionChunk parsedResponse = objectMapper.readValue(data, ChatCompletionChunk.class);
                        return Mono.justOrEmpty(parsedResponse);
                    } catch (JsonProcessingException e) {
                        return Mono.error(e);
                    }
                });
    }
}
