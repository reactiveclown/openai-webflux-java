package io.github.reactiveclown.openaiwebfluxclient.client.audio;

import reactor.core.publisher.Mono;

/**
 * Service to turn audio into text.
 */
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
