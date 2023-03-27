package com.reactiveclown.openaiwebfluxclient.client.moderations;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CreateModerationRequest.
 *
 * @param input The input text to classify
 * @param model Two content moderations models are available: text-moderation-stable and text-moderation-latest.
 *              <p>
 *              The default is text-moderation-latest which will be automatically upgraded over time.
 *              This ensures you are always using our most accurate model.
 *              If you use text-moderation-stable, we will provide advanced notice before updating the model.
 *              Accuracy of text-moderation-stable may be slightly lower than for text-moderation-latest.
 */
public record CreateModerationRequest(@JsonProperty("input") String input,
                                      @JsonProperty("model") String model) {
    public CreateModerationRequest{
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("input can't be null or empty");
    }
    public static Builder builder(String model){
        return new Builder(model);
    }
    public static final class Builder{
        String input;

        String model;

        public CreateModerationRequest build(){
            return new CreateModerationRequest(input, model);
        }
        public Builder(String input){
            this.input = input;
        }

        public Builder model(String model){
            this.model = model;
            return this;
        }
    }
}
