package com.reactiveclown.openaiwebfluxclient.client.completions;

import reactor.core.publisher.Mono;

public interface CompletionsService {

    Mono<CreateCompletionResponse> createCompletion(CreateCompletionRequest request);
}
