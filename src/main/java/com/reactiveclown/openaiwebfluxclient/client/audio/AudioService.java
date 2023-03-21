package com.reactiveclown.openaiwebfluxclient.client.audio;

import com.reactiveclown.openaiwebfluxclient.client.embeddings.CreateEmbeddingsRequest;
import reactor.core.publisher.Mono;

public interface AudioService {

    Mono<CreateTranscriptionResponse> createTranscription(CreateTranscriptionRequest request);

    Mono<CreateTranslationResponse> createTranslation(CreateTranslationRequest request);
}
