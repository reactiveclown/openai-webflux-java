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
        if(model == null || model.isBlank()) throw new IllegalArgumentException("model can't be null or blank");
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
            if (this.prompt == null) {
                this.prompt = new String[][]{{"<|endoftext|>"}};
            }
            if (this.suffix == null) {
                this.suffix = null;
            }
            if (this.maxTokens == null) {
                this.maxTokens = 16;
            }
            if (this.temperature == null) {
                this.temperature = 1.0;
            }
            if (this.topP == null) {
                this.topP = 1.0;
            }
            if (this.n == null) {
                this.n = 1;
            }
            if (this.stream == null) {
                this.stream = false;
            }
            if (this.logprobs == null) {
                this.logprobs = null;
            }
            if (this.echo == null) {
                this.echo = false;
            }
            if (this.stop == null) {
                this.stop = null;
            }
            if (this.presencePenalty == null) {
                this.presencePenalty = 0.0;
            }
            if (this.frequencyPenalty == null) {
                this.frequencyPenalty = 0.0;
            }
            if (this.bestOf == null) {
                this.bestOf = 1;
            }
            if (this.logitBias == null) {
                this.logitBias = Collections.emptyMap();
            }
            if (this.user == null) {
                this.user = "";
            }
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

