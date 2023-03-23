package com.reactiveclown.openaiwebfluxclient.client.audio;

import com.reactiveclown.openaiwebfluxclient.client.embeddings.CreateEmbeddingsRequest;
import reactor.core.publisher.Mono;

public interface AudioService {

    /**
     * Transcribes audio into the input language.
     *
     * @param request {@link CreateTranscriptionRequest}
     * @return A Mono of {@link CreateTranscriptionResponse}
     */
    Mono<CreateTranscriptionResponse> createTranscription(CreateTranscriptionRequest request);

    /**
     * Translates audio into English.
     *
     * @param request {@link CreateTranslationRequest}
     * @return A Mono of {@link CreateTranslationResponse}
     */
    Mono<CreateTranslationResponse> createTranslation(CreateTranslationRequest request);
}
