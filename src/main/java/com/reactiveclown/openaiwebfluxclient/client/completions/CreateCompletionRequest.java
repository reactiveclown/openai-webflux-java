package com.reactiveclown.openaiwebfluxclient.client.completions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * CreateCompletionRequest.
 *
 * @param model            - ID of the model to use.
 *                         You can use the List models API to see all of your available models,
 *                         or see our Model overview for descriptions of them.
 * @param prompt           - The prompt(s) to generate completions for,
 *                         encoded as a string, array of strings, array of tokens, or array of token arrays.
 *                         <p>
 *                         Note that <|endoftext|> is the document separator that the model sees during training,
 *                         so if a prompt is not specified the model will generate as if
 *                         from the beginning of a new document.
 * @param suffix           - The suffix that comes after a completion of inserted text.
 * @param maxTokens        - The maximum number of tokens to generate in the completion.
 *                         <p>
 *                         The token count of your prompt plus max_tokens cannot exceed the model's context length.
 *                         Most models have a context length of 2048 tokens
 *                         (except for the newest models, which support 4096).
 * @param temperature      - What sampling temperature to use, between 0 and 2.
 *                         Higher values like 0.8 will make the output more random,
 *                         while lower values like 0.2 will make it more focused and deterministic.
 *                         <p>
 *                         We generally recommend altering this or top_p but not both.
 * @param topP             - An alternative to sampling with temperature, called nucleus sampling,
 *                         where the model considers the results of the tokens with top_p probability mass.
 *                         So 0.1 means only the tokens comprising the top 10% probability mass are considered.
 *                         <p>
 *                         We generally recommend altering this or temperature but not both.
 * @param n                - How many completions to generate for each prompt.
 *                         <p>
 *                         Note: Because this parameter generates many completions,
 *                         it can quickly consume your token quota.
 *                         Use carefully and ensure that you have reasonable settings for max_tokens and stop.
 * @param logprobs         - Include the log probabilities on the logprobs most likely tokens,
 *                         as well the chosen tokens. For example, if logprobs is 5,
 *                         the API will return a list of the 5 most likely tokens.
 *                         The API will always return the logprob of the sampled token,
 *                         so there may be up to logprobs+1 elements in the response.
 *                         <p>
 *                         The maximum value for logprobs is 5. If you need more than this,
 *                         please contact us through our Help center and describe your use case.
 * @param echo             - Echo back the prompt in addition to the completion
 * @param stop             - Up to 4 sequences where the API will stop generating further tokens.
 *                         The returned text will not contain the stop sequence
 * @param presencePenalty  - Number between -2.0 and 2.0.
 *                         Positive values penalize new tokens based on whether they appear in the text so far,
 *                         increasing the model's likelihood to talk about new topics.
 * @param frequencyPenalty - Number between -2.0 and 2.0.
 *                         Positive values penalize new tokens based on their existing frequency in the text so far,
 *                         decreasing the model's likelihood to repeat the same line verbatim.
 * @param bestOf           - Generates best_of completions server-side and returns the "best"
 *                         (the one with the highest log probability per token). Results cannot be streamed.
 *                         <p>
 *                         When used with n, best_of controls
 *                         the number of candidate completions
 *                         and n specifies how many to return – best_of must be greater than n.
 *                         <p>
 *                         Note: Because this parameter generates many completions,
 *                         it can quickly consume your token quota. Use carefully and ensure
 *                         that you have reasonable settings for max_tokens and stop.
 * @param logitBias        - Modify the likelihood of specified tokens appearing in the completion.
 *                         <p>
 *                         Accepts a json object that maps tokens
 *                         (specified by their token ID in the GPT tokenizer)
 *                         to an associated bias value from -100 to 100.
 *                         Mathematically, the bias is added to the logits generated by the model prior to sampling.
 *                         The exact effect will vary per model,
 *                         but values between -1 and 1 should decrease or increase likelihood of selection;
 *                         values like -100 or 100 should result in a ban or exclusive selection of the relevant token.
 *                         <p>
 *                         As an example,
 *                         you can pass {"50256": -100} to prevent the <|endoftext|> token from being generated.
 * @param user             - A unique identifier representing your end-user,
 *                         which can help OpenAI to monitor and detect abuse.
 */
@JsonInclude(Include.NON_NULL)
public record CreateCompletionRequest(@JsonProperty("model") String model,
                                      @JsonProperty("prompt") List<List<String>> prompt,
                                      @JsonProperty("suffix") String suffix,
                                      @JsonProperty("max_tokens") Integer maxTokens,
                                      @JsonProperty("temperature") Double temperature,
                                      @JsonProperty("top_p") Double topP,
                                      @JsonProperty("n") Integer n,
                                      @JsonProperty("logprobs") Integer logprobs,
                                      @JsonProperty("echo") Boolean echo,
                                      @JsonProperty("stop") List<String> stop,
                                      @JsonProperty("presence_penalty") Double presencePenalty,
                                      @JsonProperty("frequency_penalty") Double frequencyPenalty,
                                      @JsonProperty("best_of") Integer bestOf,
                                      @JsonProperty("logit_bias") Map<String, Integer> logitBias,
                                      @JsonProperty("user") String user) {
    public CreateCompletionRequest {
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");
    }

    public static final class Builder {
        private final String model;
        private List<List<String>> prompt;
        private String suffix;
        private Integer maxTokens;
        private Double temperature;
        private Double topP;
        private Integer n;
        private Integer logprobs;
        private Boolean echo;
        private List<String> stop;
        private Double presencePenalty;
        private Double frequencyPenalty;
        private Integer bestOf;
        private Map<String, Integer> logitBias;
        private String user;

        public CreateCompletionRequest build() {
            return new CreateCompletionRequest(
                    model, prompt, suffix,
                    maxTokens, temperature, topP,
                    n, logprobs,
                    echo, stop, presencePenalty,
                    frequencyPenalty, bestOf, logitBias,
                    user);
        }

        public Builder(String model) {
            this.model = model;
        }

        public Builder prompt(String prompt) {
            this.prompt = List.of(List.of(prompt));
            return this;
        }

        public Builder promptList(List<String> prompt) {
            this.prompt = List.of(prompt);
            return this;
        }

        public Builder promptListOfLists(List<List<String>> prompt) {
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

        public Builder logprobs(Integer logprobs) {
            this.logprobs = logprobs;
            return this;
        }

        public Builder echo(Boolean echo) {
            this.echo = echo;
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

