package com.reactiveclown.openaiwebfluxclient.client.finetunes;

import reactor.core.publisher.Mono;

public interface FineTunesService {
    Mono<CreateFineTuneResponse> createFineTune(CreateFineTuneRequest request);

    Mono<ListFineTunesResponse> listFineTunes();

    Mono<RetrieveFineTuneResponse> retrieveFineTunes(String fineTuneId);

    Mono<CancelFineTuneResponse> cancelFineTune(String fineTuneId);

    Mono<ListFineTuneEventsResponse> listFineTuneEvents(String fineTuneId);

    Mono<DeleteFineTuneModelResponse> deleteFineTuneModel(String model);
}
