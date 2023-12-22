package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChatService {

    /**
     * Creates a completion for the chat message.
     *
     * @param request  {@link CreateChatCompletionRequest }
     * @return A {@link Mono} of {@link CreateChatCompletionResponse}
     */
    Mono<CreateChatCompletionResponse> createChatCompletion(CreateChatCompletionRequest request);

    /**
     * Creates a completion for the chat message, but with stream.
     * The method returns a Flux with chucks of the chat completion response.
     *
     * @param request  {@link CreateChatCompletionRequest }
     * @return A {@link Flux} of {@link ChatCompletionChunk}
     */
    Flux<ChatCompletionChunk> createStreamChatCompletion(CreateChatCompletionRequest request);
}
