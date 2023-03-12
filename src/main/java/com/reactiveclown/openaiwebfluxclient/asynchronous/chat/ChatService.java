package com.reactiveclown.openaiwebfluxclient.asynchronous.chat;

import reactor.core.publisher.Mono;

public interface ChatService {

    Mono<CreateChatCompletionResponse> createChatCompletion(CreateChatCompletionRequest request);
}
