package com.reactiveclown.openaiwebfluxclient.asynchronous.completions;

import reactor.core.publisher.Mono;

public interface CompletionsService {

    Mono<CreateCompletionResponse> createCompletion(CreateCompletionRequest request);
}
