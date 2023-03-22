package com.reactiveclown.openaiwebfluxclient.client.models;

import reactor.core.publisher.Mono;

public interface ModelsService {

    /**
     * Lists the currently available models,
     * and provides basic information about each one such as the owner and availability.
     *
     * @return {@link ListModelsResponse}
     */
    Mono<ListModelsResponse> listModels();

    /**
     * Retrieves a model instance,
     * providing basic information about the model such as the owner and permissioning.
     *
     * @param model - The ID of the model to use for this request.
     * @return {@link RetrieveModelResponse}
     */
    Mono<RetrieveModelResponse> retrieveModel(String model);
}
