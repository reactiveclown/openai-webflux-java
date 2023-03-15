package com.reactiveclown.openaiwebfluxclient.client.edits;

import reactor.core.publisher.Mono;

public interface EditsService {
    Mono<CreateEditResponse> createEdit(CreateEditRequest request);
}
