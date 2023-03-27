package com.reactiveclown.openaiwebfluxclient.client.moderations;

import reactor.core.publisher.Mono;

/**
 * Given a input text, outputs if the model classifies it as violating OpenAI's content policy
 */
public interface ModerationsService {
    /**
     * Classifies if text violates OpenAI's Content Policy
     * @param request {@link CreateModerationRequest}
     * @return A Mono of {@link CreateModerationResponse}
     */
    Mono<CreateModerationResponse> createModeration(CreateModerationRequest request);
}
