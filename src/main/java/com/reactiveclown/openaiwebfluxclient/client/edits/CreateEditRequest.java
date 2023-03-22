package com.reactiveclown.openaiwebfluxclient.client.edits;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateEditRequest(@JsonProperty("model") String model,
                                @JsonProperty("input") String input,
                                @JsonProperty("instruction") String instruction,
                                @JsonProperty("n") Integer n,
                                @JsonProperty("temperature") Double temperature,
                                @JsonProperty("top_p") Double topP) {
    public CreateEditRequest {
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");

        if (instruction == null || instruction.isBlank())
            throw new IllegalArgumentException("instruction value can't be null or blank");

    }

    public static final class Builder {
        String model;
        String input;
        String instruction;
        Integer n;
        Double temperature;
        Double topP;

        public CreateEditRequest build() {
            return new CreateEditRequest(
                    model, input, instruction,
                    n, temperature, topP);
        }

        public Builder(String model, String instruction){
            this.model = model;
            this.instruction = instruction;
        }

        public Builder input(String input){
            this.input = input;
            return this;
        }

        public Builder n(Integer n){
            this.n = n;
            return this;
        }

        public Builder temperature(Double temperature){
            this.temperature = temperature;
            return this;
        }

        public Builder topP(Double topP){
            this.topP = topP;
            return this;
        }
    }
}
