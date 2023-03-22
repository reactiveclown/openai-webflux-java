package com.reactiveclown.openaiwebfluxclient.client.finetunes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateFineTuneResponse(@JsonProperty("id") String id,
                                     @JsonProperty("object") String object,
                                     @JsonProperty("model") String model,
                                     @JsonProperty("created_at") Long createdAt,
                                     @JsonProperty("events") List<Event> events,
                                     @JsonProperty("fine_tune_model") String fineTunedModel,
                                     @JsonProperty("hyperparams") HyperParameters hyperparams,
                                     @JsonProperty("organization_id") String organizationId,
                                     @JsonProperty("result_files") List<FileData> resultFiles,
                                     @JsonProperty("status") String status,
                                     @JsonProperty("training_files") List<FileData> trainingFiles,
                                     @JsonProperty("updated_at") Long updatedAt,
                                     @JsonProperty("validation_files") List<FileData> validationFiles) {
}

record Event(@JsonProperty("object") String object,
             @JsonProperty("created_at") Long createdAt,
             @JsonProperty("level") String level,
             @JsonProperty("message") String message) {
}

record HyperParameters(@JsonProperty("batch_size") Integer batchSize,
                       @JsonProperty("learning_multiplier") Double learningMultiplier,
                       @JsonProperty("n_epochs") Integer nEpochs,
                       @JsonProperty("prompt_loss_weight") Double promptLossWeight) {
}

record FileData(@JsonProperty("id") String id,
                @JsonProperty("object") String object,
                @JsonProperty("bytes") Integer bytes,
                @JsonProperty("created_at") Long createdAt,
                @JsonProperty("filename") String filename,
                @JsonProperty("purpose") String purpose) {
}