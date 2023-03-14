package com.reactiveclown.openaiwebfluxclient.asynchronous.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public record CreateChatCompletionRequest(@JsonProperty("model") String model,
                                          @JsonProperty("messages") List<Message> messages,
                                          @JsonProperty("temperature") Double temperature,
                                          @JsonProperty("top_p") Double topP,
                                          @JsonProperty("n") Integer n,
                                          @JsonProperty("stream") Boolean stream,
                                          @JsonProperty("stop") List<String> stop,
                                          @JsonProperty("max_tokens") Integer maxTokens,
                                          @JsonProperty("presence_penalty") Double presencePenalty,
                                          @JsonProperty("frequency_penalty") Double frequencyPenalty,
                                          @JsonProperty("logit_bias") Map<String, Integer> logitBias,
                                          @JsonProperty("user") String user) {
    public CreateChatCompletionRequest {
        //Providing the default values
        if (temperature == null) temperature = 1.0;
        if (topP == null) topP = 1.0;
        if (n == null) n = 1;
        if (stream == null) stream = false;
        if (presencePenalty == null) presencePenalty = 0.0;
        if (frequencyPenalty == null) frequencyPenalty = 0.0;
        if (logitBias == null) logitBias = Collections.emptyMap();
        if (user == null) user = "";

        //Checking the restrictions
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");

        if (messages == null || messages.isEmpty())
            throw new IllegalArgumentException("messages can't be null or empty");

        if (temperature > 2.0 || temperature < 0.0)
            throw new IllegalArgumentException("temperature value should be between [0.0, 2.0]");

        if (topP > 1.0 || topP < 0.0)
            throw new IllegalArgumentException("topP value should be between [0.0, 1.0]");

        if (stop != null && stop.size() > 4)
            throw new IllegalArgumentException("stop size can't be greater than 4");

        if (presencePenalty > 2.0 || presencePenalty < -2.0)
            throw new IllegalArgumentException("presencePenalty value should be between [-2.0, 2.0]");

        if (frequencyPenalty > 2.0 || frequencyPenalty < -2.0)
            throw new IllegalArgumentException("frequencyPenalty value should be between [-2.0, 2.0]");
    }

    public static final class Builder {
        private final String model;
        private final List<Message> messages;
        private Double temperature;
        private Double topP;
        private Integer n;
        private Boolean stream;
        private List<String> stop;
        private Integer maxTokens;
        private Double presencePenalty;
        private Double frequencyPenalty;
        private Map<String, Integer> logitBias;
        private String user;

        public CreateChatCompletionRequest build() {
            return new CreateChatCompletionRequest(
                    model, messages, temperature,
                    topP, n, stream,
                    stop, maxTokens, presencePenalty,
                    frequencyPenalty, logitBias, user);
        }

        public Builder(String model, List<Message> messages) {
            this.model = model;
            this.messages = messages;
        }

        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder topP(Double topP) {
            this.topP = topP;
            return this;
        }

        public Builder n(Integer n) {
            this.n = n;
            return this;
        }

        public Builder stream(Boolean stream) {
            this.stream = stream;
            return this;
        }

        public Builder stop(String stop) {
            this.stop = List.of(stop);
            return this;
        }

        public Builder stop(List<String> stop) {
            this.stop = stop;
            return this;
        }

        public Builder maxTokens(Integer maxTokens) {
            this.maxTokens = maxTokens;
            return this;
        }

        public Builder presencePenalty(Double presencePenalty) {
            this.presencePenalty = presencePenalty;
            return this;
        }

        public Builder frequencyPenalty(Double frequencyPenalty) {
            this.frequencyPenalty = frequencyPenalty;
            return this;
        }

        public Builder logitBias(Map<String, Integer> logitBias) {
            this.logitBias = logitBias;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }

    }
}