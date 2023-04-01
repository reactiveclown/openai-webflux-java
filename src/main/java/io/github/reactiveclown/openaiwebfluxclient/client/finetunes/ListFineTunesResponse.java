package io.github.reactiveclown.openaiwebfluxclient.client.finetunes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ListFineTunesResponse(@JsonProperty("object") String object,
                                    @JsonProperty("data") List<FineTuneData> data) {
}

record FineTuneData(@JsonProperty("id") String id,
                    @JsonProperty("object") String object,
                    @JsonProperty("model") String model,
                    @JsonProperty("created_at") Long createdAt,
                    @JsonProperty("fine_tuned_model") String fineTunedModel,
                    @JsonProperty("hyperparams") HyperParametersData hyperparams,
                    @JsonProperty("organizationId") String organizationId,
                    @JsonProperty("result_files") List<FileData> resultFiles,
                    @JsonProperty("status") String status,
                    @JsonProperty("validation_files") List<FileData> validationFiles,
                    @JsonProperty("training_files") List<FileData> trainingFiles,
                    @JsonProperty("updated_at") Long updatedAt
) {
}
