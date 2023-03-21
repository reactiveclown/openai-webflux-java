package com.reactiveclown.openaiwebfluxclient.client.embeddings;

import reactor.core.publisher.Mono;

public interface EmbeddingsService {

    Mono<CreateEmbeddingsResponse> createEmbeddings(CreateEmbeddingsRequest request);

}
