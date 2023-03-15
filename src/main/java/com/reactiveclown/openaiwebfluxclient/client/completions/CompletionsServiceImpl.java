package com.reactiveclown.openaiwebfluxclient.client.completions;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CompletionsServiceImpl implements CompletionsService{

    private final WebClient client;

    public CompletionsServiceImpl(WebClient client){
        this.client = client;
    }

    @Override
    public Mono<CreateCompletionResponse> createCompletion(CreateCompletionRequest request) {
        String createCompletionUri = "/completions";
        return client.post()
                .uri(createCompletionUri)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateCompletionResponse.class);
    }
}
