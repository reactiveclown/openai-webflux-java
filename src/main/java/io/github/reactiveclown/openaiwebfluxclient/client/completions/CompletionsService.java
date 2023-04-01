package io.github.reactiveclown.openaiwebfluxclient.client.completions;

import reactor.core.publisher.Mono;

public interface CompletionsService {

    /**
     * Creates a completion for the provided prompt and parameters.
     *
     * @param request {@link CreateCompletionRequest}
     * @return A Mono of {@link CreateCompletionResponse}
     */
    Mono<CreateCompletionResponse> createCompletion(CreateCompletionRequest request);
}
