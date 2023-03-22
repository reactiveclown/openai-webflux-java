package com.reactiveclown.openaiwebfluxclient.client.moderations;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ModerationsServiceImpl implements ModerationsService{

    private final WebClient client;
    public ModerationsServiceImpl(WebClient client){
        this.client = client;
    }
    @Override
    public Mono<CreateModerationResponse> createModeration(CreateModerationRequest request) {
        String createModerationUrl = "/moderations";
        return client.post()
                .uri(createModerationUrl)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateModerationResponse.class);
    }
}
