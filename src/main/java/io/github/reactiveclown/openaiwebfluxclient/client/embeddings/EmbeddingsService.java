package io.github.reactiveclown.openaiwebfluxclient.client.embeddings;

import reactor.core.publisher.Mono;

public interface EmbeddingsService {

    /**
     * Creates an embedding vector representing the input text.
     *
     * @param request {@link CreateEmbeddingsRequest}
     * @return A Mono of {@link CreateEmbeddingsResponse}
     */
    Mono<CreateEmbeddingsResponse> createEmbeddings(CreateEmbeddingsRequest request);

}
