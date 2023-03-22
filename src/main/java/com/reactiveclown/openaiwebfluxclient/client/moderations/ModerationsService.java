package com.reactiveclown.openaiwebfluxclient.client.moderations;

import reactor.core.publisher.Mono;

public interface ModerationsService {
    Mono<CreateModerationResponse> createModeration(CreateModerationRequest request);
}
