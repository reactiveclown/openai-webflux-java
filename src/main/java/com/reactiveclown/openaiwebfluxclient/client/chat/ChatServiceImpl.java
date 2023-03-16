package com.reactiveclown.openaiwebfluxclient.client.chat;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ChatServiceImpl implements ChatService{

    private final WebClient client;
    public ChatServiceImpl(WebClient client){
        this.client = client;
    }

    @Override
    public Mono<CreateChatCompletionResponse> createChatCompletion(CreateChatCompletionRequest request) {
        String createChatCompletionUrl = "/completions";
        return client.post()
                .uri(createChatCompletionUrl)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateChatCompletionResponse.class);
    }
}
