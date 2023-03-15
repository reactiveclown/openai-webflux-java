package com.reactiveclown.openaiwebfluxclient.client.chat;

import reactor.core.publisher.Mono;

public interface ChatService {

    Mono<CreateChatCompletionResponse> createChatCompletion(CreateChatCompletionRequest request);
}
