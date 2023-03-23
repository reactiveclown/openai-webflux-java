package com.reactiveclown.openaiwebfluxclient.client.edits;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CreateEditRequest.
 *
 * @param model       - ID of the model to use.
 *                    You can use the text-davinci-edit-001 or code-davinci-edit-001 model with this endpoint.
 * @param input       - The input text to use as a starting point for the edit.
 * @param instruction - The instruction that tells the model how to edit the prompt.
 * @param n           - How many edits to generate for the input and instruction.
 * @param temperature - What sampling temperature to use,
 *                    between 0 and 2. Higher values like 0.8 will make the output more random,
 *                    while lower values like 0.2 will make it more focused and deterministic.
 *                    <p>
 *                    We generally recommend altering this or top_p but not both.
 * @param topP        - An alternative to sampling with temperature, called nucleus sampling,
 *                    where the model considers the results of the tokens with top_p probability mass.
 *                    So 0.1 means only the tokens comprising the top 10% probability mass are considered.
 *                    <p>
 *                    We generally recommend altering this or temperature but not both.
 */
@JsonInclude(Include.NON_NULL)
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

    public static Builder builder(String model, String instruction) {
        return new Builder(model, instruction);
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

        public Builder(String model, String instruction) {
            this.model = model;
            this.instruction = instruction;
        }

        public Builder input(String input) {
            this.input = input;
            return this;
        }

        public Builder n(Integer n) {
            this.n = n;
            return this;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder topP(Double topP) {
            this.topP = topP;
            return this;
        }
    }
}
