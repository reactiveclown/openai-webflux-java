package com.reactiveclown.openaiwebfluxclient.asynchronous.edits;

import reactor.core.publisher.Mono;

public interface EditsService {
    Mono<CreateEditResponse> createEdit(CreateEditRequest request);
}
