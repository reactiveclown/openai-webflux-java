package io.github.reactiveclown.openaiwebfluxclient.client.edits;

import reactor.core.publisher.Mono;

public interface EditsService {
    /**
     * Creates a new edit for the provided input, instruction, and parameters.
     *
     * @param request {@link CreateEditRequest}
     * @return A Mono of {@link CreateEditResponse}
     */
    Mono<CreateEditResponse> createEdit(CreateEditRequest request);
}
