package com.reactiveclown.openaiwebfluxclient.client.edits;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EditsServiceImpl implements EditsService {

    private final WebClient client;

    public EditsServiceImpl(WebClient client) {
        this.client = client;
    }

    @Override
    public Mono<CreateEditResponse> createEdit(CreateEditRequest request) {
        String createEditUrl = "/edits";
        return client.post()
                .uri(createEditUrl)
                .retrieve()
                .bodyToMono(CreateEditResponse.class);
    }
}
