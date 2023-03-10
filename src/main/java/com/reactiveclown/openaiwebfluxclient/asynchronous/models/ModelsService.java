package com.reactiveclown.openaiwebfluxclient.asynchronous.models;

import reactor.core.publisher.Mono;

public interface ModelsService {

    Mono<ListModelsResponse> listModels();

    Mono<RetrieveModelResponse> retrieveModel(String model);
}
