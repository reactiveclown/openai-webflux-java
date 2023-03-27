package com.reactiveclown.openaiwebfluxclient.client.finetunes;

import reactor.core.publisher.Mono;

/**
 * Manage fine-tuning jobs to tailor a model to your specific training data.
 */
public interface FineTunesService {
    /**
     * Creates a job that fine-tunes a specified model from a given dataset.
     * <p>
     * Response includes details of the enqueued job including job status and the name of the fine-tuned models once complete.
     *
     * @param request {@link CreateFineTuneRequest}
     * @return A Mono of {@link CreateFineTuneResponse}
     */
    Mono<CreateFineTuneResponse> createFineTune(CreateFineTuneRequest request);

    /**
     * List your organization's fine-tuning jobs
     *
     * @return A Mono of {@link ListFineTunesResponse}
     */
    Mono<ListFineTunesResponse> listFineTunes();

    /**
     * Gets info about the fine-tune job.
     *
     * @param fineTuneId The ID of the fine-tune job
     * @return A Mono of {RetrieveFineTuneResponse}
     */
    Mono<RetrieveFineTuneResponse> retrieveFineTunes(String fineTuneId);

    /**
     * Immediately cancel a fine-tune job.
     *
     * @param fineTuneId The ID of the fine-tune job to cancel
     * @return A Mono of {@link CancelFineTuneResponse}
     */
    Mono<CancelFineTuneResponse> cancelFineTune(String fineTuneId);

    /**
     * Get fine-grained status updates for a fine-tune job.
     *
     * @param fineTuneId The ID of the fine-tune job to get events for.
     * @return A Mono of {@link ListFineTuneEventsResponse}
     */
    Mono<ListFineTuneEventsResponse> listFineTuneEvents(String fineTuneId);

    /**
     * Delete a fine-tuned model. You must have the Owner role in your organization.
     *
     * @param model The model to delete
     * @return A Mono of {@link DeleteFineTuneModelResponse}
     */
    Mono<DeleteFineTuneModelResponse> deleteFineTuneModel(String model);
}
