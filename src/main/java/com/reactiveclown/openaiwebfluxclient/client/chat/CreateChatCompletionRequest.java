package com.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * CreateChatCompletionRequest.
 *
 * @param model            - ID of the model to use.
 *                         See the model endpoint compatibility table for details on which models work with the Chat API.
 * @param messages         - The messages to generate chat completions for, in the chat format.
 * @param temperature      - What sampling temperature to use, between 0 and 2.
 *                         Higher values like 0.8 will make the output more random,
 *                         while lower values like 0.2 will make it more focused and deterministic.
 *                         <p>
 *                         We generally recommend altering this or top_p but not both.
 * @param topP             - An alternative to sampling with temperature,
 *                         called nucleus sampling,
 *                         where the model considers the results of the tokens with top_p probability mass.
 *                         So 0.1 means only the tokens comprising the top 10% probability mass are considered.
 *                         <p>
 *                         We generally recommend altering this or temperature but not both.
 * @param n                - How many chat completion choices to generate for each input message.
 * @param stop             - Up to 4 sequences where the API will stop generating further tokens.
 * @param maxTokens        - The maximum number of tokens to generate in the chat completion.
 *                         <p>
 *                         The total length of input tokens and generated tokens
 *                         is limited by the model's context length.
 * @param presencePenalty  - Number between -2.0 and 2.0.
 *                         Positive values penalize new tokens based on whether they appear in the text so far,
 *                         increasing the model's likelihood to talk about new topics.
 * @param frequencyPenalty - Number between -2.0 and 2.0.
 *                         Positive values penalize new tokens based on their existing frequency in the text so far,
 *                         decreasing the model's likelihood to repeat the same line verbatim.
 * @param logitBias        - Modify the likelihood of specified tokens appearing in the completion.
 *                         <p>
 *                         Accepts a json object that maps tokens (specified by their token ID in the tokenizer)
 *                         to an associated bias value from -100 to 100. Mathematically,
 *                         the bias is added to the logits generated by the model prior to sampling.
 *                         The exact effect will vary per model,
 *                         but values between -1 and 1 should decrease or increase likelihood of selection;
 *                         values like -100 or 100 should result in a ban or exclusive selection of the relevant token.
 * @param user             - A unique identifier representing your end-user,
 *                         which can help OpenAI to monitor and detect abuse
 */
public record CreateChatCompletionRequest(@JsonProperty("model") String model,
                                          @JsonProperty("messages") List<MessageData> messages,
                                          @JsonProperty("temperature") Double temperature,
                                          @JsonProperty("top_p") Double topP,
                                          @JsonProperty("n") Integer n,
                                          @JsonProperty("stop") List<String> stop,
                                          @JsonProperty("max_tokens") Integer maxTokens,
                                          @JsonProperty("presence_penalty") Double presencePenalty,
                                          @JsonProperty("frequency_penalty") Double frequencyPenalty,
                                          @JsonProperty("logit_bias") Map<String, Integer> logitBias,
                                          @JsonProperty("user") String user) {
    public CreateChatCompletionRequest {
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");

        if (messages == null || messages.isEmpty())
            throw new IllegalArgumentException("messages can't be null or empty");
    }

    public static Builder builder(String model, List<MessageData> messages) {
        return new Builder(model, messages);
    }

    public static final class Builder {
        private final String model;
        private final List<MessageData> messages;
        private Double temperature;
        private Double topP;
        private Integer n;
        private List<String> stop;
        private Integer maxTokens;
        private Double presencePenalty;
        private Double frequencyPenalty;
        private Map<String, Integer> logitBias;
        private String user;

        public CreateChatCompletionRequest build() {
            return new CreateChatCompletionRequest(
                    model, messages, temperature,
                    topP, n, stop, maxTokens,
                    presencePenalty, frequencyPenalty, logitBias,
                    user);
        }

        public Builder(String model, List<MessageData> messages) {
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