package com.reactiveclown.openaiwebfluxclient.client.chat;

import reactor.core.publisher.Mono;

public interface ChatService {

    /**
     * Creates a completion for the chat message.
     *
     * @param request - {@link CreateChatCompletionRequest }
     * @return {@link CreateChatCompletionResponse}
     */
    Mono<CreateChatCompletionResponse> createChatCompletion(CreateChatCompletionRequest request);
}
