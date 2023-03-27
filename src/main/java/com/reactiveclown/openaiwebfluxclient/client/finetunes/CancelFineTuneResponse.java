package com.reactiveclown.openaiwebfluxclient.client.finetunes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CancelFineTuneResponse(@JsonProperty("id") String id,
                                     @JsonProperty("object") String object,
                                     @JsonProperty("model") String model,
                                     @JsonProperty("created_at") Long createdAt,
                                     @JsonProperty("events") List<EventData> events,
                                     @JsonProperty("fine_tuned_model") String fineTunedModel,
                                     @JsonProperty("hyperparams") HyperParametersData hyperparams,
                                     @JsonProperty("organization_id") String organizationId,
                                     @JsonProperty("result_files") List<FileData> resultFiles,
                                     @JsonProperty("status") String status,
                                     @JsonProperty("validation_files") List<FileData> validationFiles,
                                     @JsonProperty("training_files") List<FileData> trainingFiles,
                                     @JsonProperty("updated_at") Long updatedAt) {
}
