package com.reactiveclown.openaiwebfluxclient.asynchronous.completions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.Map;

public record CreateCompletionRequest(@JsonProperty("model") String model,
                                      @JsonProperty("prompt") String[][] prompt,
                                      @JsonProperty("suffix") String suffix,
                                      @JsonProperty("max_tokens") Integer maxTokens,
                                      @JsonProperty("temperature") Double temperature,
                                      @JsonProperty("top_p") Double topP,
                                      @JsonProperty("n") Integer n,
                                      @JsonProperty("stream") Boolean stream,
                                      @JsonProperty("logprobs") Integer logprobs,
                                      @JsonProperty("echo") Boolean echo,
                                      @JsonProperty("stop") String[] stop,
                                      @JsonProperty("presence_penalty") Double presencePenalty,
                                      @JsonProperty("frequency_penalty") Double frequencyPenalty,
                                      @JsonProperty("best_of") Integer bestOf,
                                      @JsonProperty("logit_bias") Map<String, Integer> logitBias,
                                      @JsonProperty("user") String user) {
    public CreateCompletionRequest {
        //Providing the default values
        if (prompt == null) prompt = new String[][]{{"<|endoftext|>"}};
        if (maxTokens == null) maxTokens = 16;
        if (temperature == null) temperature = 1.0;
        if (topP == null) topP = 1.0;
        if (n == null) n = 1;
        if (stream == null) stream = false;
        if (echo == null) echo = false;
        if (presencePenalty == null) presencePenalty = 0.0;
        if (frequencyPenalty == null) frequencyPenalty = 0.0;
        if (bestOf == null) bestOf = 1;
        if (logitBias == null) logitBias = Collections.emptyMap();
        if (user == null) user = "";

        //Checking the restrictions
        if (model == null || model.isBlank()) throw new IllegalArgumentException("model value can't be null or blank");
        if (temperature > 2.0 || temperature < 0.0) throw new IllegalArgumentException("temperature value should be between [0.0, 2.0]");
        if (topP > 1.0 || topP < 0.0) throw new IllegalArgumentException("topP value should be between [0.0, 1.0]");
        if (logprobs != null && logprobs < 0) throw new IllegalArgumentException("logprobs value should be greater than 0.0");
        if (stop != null && stop.length > 4) throw new IllegalArgumentException("stop size can't be greater than 4");
        if (presencePenalty > 2.0 || presencePenalty < -2.0) throw new IllegalArgumentException("presencePenalty value should be between [-2.0, 2.0]");
        if (frequencyPenalty > 2.0 || frequencyPenalty < -2.0) throw new IllegalArgumentException("frequencyPenalty value should be between [-2.0, 2.0]");

    }

    public static final class Builder {
        String model;
        String[][] prompt;
        String suffix;
        Integer maxTokens;
        Double temperature;
        Double topP;
        Integer n;
        Boolean stream;
        Integer logprobs;
        Boolean echo;
        String[] stop;
        Double presencePenalty;
        Double frequencyPenalty;
        Integer bestOf;
        Map<String, Integer> logitBias;
        String user;

        public CreateCompletionRequest build() {
            return new CreateCompletionRequest(
                    model, prompt, suffix,
                    maxTokens, temperature, topP,
                    n, stream, logprobs,
                    echo, stop, presencePenalty,
                    frequencyPenalty, bestOf, logitBias,
                    user);
        }

        public Builder(String model) {
            this.model = model;
        }

        public Builder prompt(String prompt) {
            this.prompt = new String[1][1];
            this.prompt[0][0] = prompt;
            return this;
        }

        public Builder prompt(String[] prompt) {
            this.prompt = new String[1][prompt.length];
            this.prompt[0] = prompt;
            return this;
        }

        public Builder prompt(String[][] prompt) {
            this.prompt = prompt;
            return this;
        }

        public Builder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public Builder maxTokens(Integer maxTokens) {
            this.maxTokens = maxTokens;
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

        public Builder n(Integer n) {
            this.n = n;
            return this;
        }

        public Builder stream(Boolean stream) {
            this.stream = stream;
            return this;
        }

        public Builder logprobs(Integer logprobs) {
            this.logprobs = logprobs;
            return this;
        }

        public Builder echo(Boolean echo) {
            this.echo = echo;
            return this;
        }

        public Builder stop(String stop) {
            this.stop = new String[1];
            this.stop[0] = stop;
            return this;
        }

        public Builder stop(String[] stop) {
            this.stop = stop;
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

        public Builder bestOf(Integer bestOf) {
            this.bestOf = bestOf;
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

