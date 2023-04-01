package io.github.reactiveclown.openaiwebfluxclient.client.finetunes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @param trainingFile                 The ID of an uploaded file that contains training data.
 * @param validationFile               The ID of an uploaded file that contains validation data.
 * @param model                        The name of the base model to fine-tune.
 *                                     You can select one of "ada", "babbage", "curie", "davinci",
 *                                     or a fine-tuned model created after 2022-04-21.
 * @param nEpochs                      The number of epochs to train the model for.
 *                                     An epoch refers to one full cycle through the training dataset.
 * @param batchSize                    The batch size to use for training.
 *                                     The batch size is the number of training examples
 *                                     used to train a single forward and backward pass.
 *                                     <p>
 *                                     By default, the batch size will be dynamically configured to be ~0.2%
 *                                     of the number of examples in the training set, capped at 256 - in general,
 *                                     we've found that larger batch sizes tend to work better for larger datasets.
 * @param learningRateMultiplier       The learning rate multiplier to use for training.
 *                                     The fine-tuning learning rate is the original
 *                                     learning rate used for pretraining multiplied by this value.
 *                                     <p>
 *                                     By default, the learning rate multiplier is the 0.05, 0.1, or 0.2
 *                                     depending on final batch_size
 *                                     (larger learning rates tend to perform better with larger batch sizes).
 *                                     We recommend experimenting with values in the range 0.02 to 0.2
 *                                     to see what produces the best results.
 * @param promptLossWeight             The weight to use for loss on the prompt tokens.
 *                                     This controls how much the model tries to learn to generate the prompt
 *                                     (as compared to the completion which always has a weight of 1.0),
 *                                     and can add a stabilizing effect to training when completions are short.
 *                                     <p>
 *                                     If prompts are extremely long (relative to completions),
 *                                     it may make sense to reduce this weight so as to
 *                                     avoid over-prioritizing learning the prompt.
 * @param computeClassificationMetrics If set, we calculate classification-specific metrics
 *                                     such as accuracy and F-1 score using the validation set at the end of every epoch.
 *                                     These metrics can be viewed in the results file.
 *                                     <p>
 *                                     In order to compute classification metrics,
 *                                     you must provide a validation_file.
 *                                     Additionally, you must specify classification_n_classes for multiclass
 *                                     classification or classification_positive_class for binary classification.
 * @param classificationNClasses       The number of classes in a classification task.
 *                                     <p>
 *                                     This parameter is required for multiclass classification.
 * @param classificationPositiveClass  The positive class in binary classification.
 *                                     <p>
 *                                     This parameter is needed to generate precision, recall,
 *                                     and F1 metrics when doing binary classification.
 * @param classificationBetas          If this is provided, we calculate F-beta scores at the specified beta values.
 *                                     The F-beta score is a generalization of F-1 score.
 *                                     This is only used for binary classification.
 *                                     <p>
 *                                     With a beta of 1 (i.e. the F-1 score),
 *                                     precision and recall are given the same weight.
 *                                     A larger beta score puts more weight on recall and less on precision.
 *                                     A smaller beta score puts more weight on precision and less on recall.
 * @param suffix                       A string of up to 40 characters that will be added to your fine-tuned model name.
 *                                     <p>
 *                                     For example, a suffix of "custom-model-name"
 *                                     would produce a model name like
 *                                     ada:ft-your-org:custom-model-name-2022-02-15-04-21-04.
 */
@JsonInclude(Include.NON_NULL)
public record CreateFineTuneRequest(@JsonProperty("training_file") String trainingFile,
                                    @JsonProperty("validation_file") String validationFile,
                                    @JsonProperty("model") String model,
                                    @JsonProperty("n_epochs") Integer nEpochs,
                                    @JsonProperty("batch_size") Integer batchSize,
                                    @JsonProperty("learning_rate_multiplier") Double learningRateMultiplier,
                                    @JsonProperty("prompt_loss_weight") Double promptLossWeight,
                                    @JsonProperty("compute_classification_metrics") Boolean computeClassificationMetrics,
                                    @JsonProperty("classification_n_classes") Integer classificationNClasses,
                                    @JsonProperty("classification_positive_class") String classificationPositiveClass,
                                    @JsonProperty("classification_betas") List<Double> classificationBetas,
                                    @JsonProperty("suffix") String suffix) {
    public CreateFineTuneRequest {
        if (trainingFile == null || trainingFile.isEmpty())
            throw new IllegalArgumentException("training file can't be null or empty");
    }

    public static Builder builder(String trainingFile) {
        return new Builder(trainingFile);
    }

    public static final class Builder {
        String trainingFile;
        String validationFile;
        String model;
        Integer nEpochs;
        Integer batchSize;
        Double learningRateMultiplier;
        Double promptLossWeight;
        Boolean computeClassificationMetrics;
        Integer classificationNClasses;
        String classificationPositiveClass;
        List<Double> classificationBetas;
        String suffix;

        public CreateFineTuneRequest build() {
            return new CreateFineTuneRequest(
                    trainingFile, validationFile, model,
                    nEpochs, batchSize, learningRateMultiplier,
                    promptLossWeight, computeClassificationMetrics, classificationNClasses,
                    classificationPositiveClass, classificationBetas, suffix);
        }

        public Builder(String trainingFile) {
            this.trainingFile = trainingFile;
        }

        public Builder validationFile(String validationFile) {
            this.validationFile = validationFile;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder nEpochs(Integer nEpochs) {
            this.nEpochs = nEpochs;
            return this;
        }

        public Builder batchSize(Integer batchSize) {
            this.batchSize = batchSize;
            return this;
        }

        public Builder learningRateMultiplier(Double learningRateMultiplier) {
            this.learningRateMultiplier = learningRateMultiplier;
            return this;
        }

        public Builder promptLossWeight(Double promptLossWeight) {
            this.promptLossWeight = promptLossWeight;
            return this;
        }

        public Builder computeClassificationMetrics(Boolean computeClassificationMetrics) {
            this.computeClassificationMetrics = computeClassificationMetrics;
            return this;
        }

        public Builder classificationNClasses(Integer classificationNClasses) {
            this.classificationNClasses = classificationNClasses;
            return this;
        }

        public Builder classificationPositiveClass(String classificationPositiveClass) {
            this.classificationPositiveClass = classificationPositiveClass;
            return this;
        }

        public Builder classificationBetas(List<Double> classificationBetas) {
            this.classificationBetas = classificationBetas;
            return this;
        }

        public Builder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

    }
}
