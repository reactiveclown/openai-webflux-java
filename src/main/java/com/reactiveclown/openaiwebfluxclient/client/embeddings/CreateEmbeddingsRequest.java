package com.reactiveclown.openaiwebfluxclient.client.embeddings;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateEmbeddingsRequest(@JsonProperty("model") String model,
                                      @JsonProperty("input") List<String> input,
                                      @JsonProperty("user") String user) {
    public CreateEmbeddingsRequest {
        if (user == null) user = "";

        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");

        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("input can't be null or empty");
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
