package io.github.reactiveclown.openaiwebfluxclient.client.embeddings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * CreateEmbeddingsRequest.
 *
 * @param model - ID of the model to use. You can use the List models API to see all of your available models,
 *              or see our Model overview for descriptions of them.
 * @param input - Input text to get embeddings for,
 *              encoded as a string or array of tokens.
 *              To get embeddings for multiple inputs in a single request,
 *              pass an array of strings or array of token arrays.
 *              Each input must not exceed 8192 tokens in length.
 * @param user  - A unique identifier representing your end-user,
 *              which can help OpenAI to monitor and detect abuse
 */
@JsonInclude(Include.NON_NULL)
public record CreateEmbeddingsRequest(@JsonProperty("model") String model,
                                      @JsonProperty("input") List<String> input,
                                      @JsonProperty("user") String user) {
    public CreateEmbeddingsRequest {
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");

        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("input can't be null or empty");
    }

    public static Builder builder(String model, List<String> input) {
        return new Builder(model, input);
    }

    public static Builder builder(String model, String input) {
        return new Builder(model, input);
    }

    public static final class Builder {
        String model;

        List<String> input;

        String user;

        public CreateEmbeddingsRequest build() {
            return new CreateEmbeddingsRequest(
                    model, input, user);
        }

        public Builder(String model, List<String> input) {
            this.model = model;
            this.input = input;
        }

        public Builder(String model, String input) {
            this.model = model;
            this.input = List.of(input);
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

    }
}
