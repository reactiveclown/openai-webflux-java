package com.reactiveclown.openaiwebfluxclient.asynchronous.edits;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateEditRequest(@JsonProperty("model") String model,
                                @JsonProperty("input") String input,
                                @JsonProperty("instruction") String instruction,
                                @JsonProperty("n") Integer n,
                                @JsonProperty("temperature") Double temperature,
                                @JsonProperty("top_p") Double topP) {
    public CreateEditRequest {
        //Providing the default values
        if (input == null) input = "";
        if (n == null) n = 1;
        if (temperature == null) temperature = 1.0;
        if (topP == null) topP = 1.0;

        //Checking the restrictions
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");

        if (instruction == null || instruction.isBlank())
            throw new IllegalArgumentException("instruction value can't be null or blank");

        if (temperature > 2.0 || temperature < 0.0)
            throw new IllegalArgumentException("temperature value should be between [0.0, 2.0]");

        if (topP > 1.0 || topP < 0.0)
            throw new IllegalArgumentException("topP value should be between [0.0, 1.0]");
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
