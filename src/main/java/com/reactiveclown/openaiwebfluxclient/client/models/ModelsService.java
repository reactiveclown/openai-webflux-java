package com.reactiveclown.openaiwebfluxclient.client.models;

import reactor.core.publisher.Mono;

public interface ModelsService {

    Mono<ListModelsResponse> listModels();

    Mono<RetrieveModelResponse> retrieveModel(String model);
}
