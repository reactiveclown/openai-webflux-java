package com.reactiveclown.openaiwebfluxclient.client.finetunes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateFineTuneRequest(@JsonProperty("training_file") String trainingFile,
                                    @JsonProperty("validation_file") String validationFile,
                                    @JsonProperty("model") String model,
                                    @JsonProperty("n_epochs")Integer nEpochs,
                                    @JsonProperty("batch_size")Integer batchSize,
                                    @JsonProperty("learning_rate_multiplier")Double learningRateMultiplier,
                                    @JsonProperty("prompt_loss_weight")Double promptLossWeight,
                                    @JsonProperty("compute_classification_metrics")Boolean computeClassificationMetrics,
                                    @JsonProperty("classification_n_classes")Integer classificationNClasses,
                                    @JsonProperty("classification_positive_class")String classificationPositiveClass,
                                    @JsonProperty("classification_betas") List<Double> classificationBetas) {
}
