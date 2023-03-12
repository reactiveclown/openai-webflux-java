package com.reactiveclown.openaiwebfluxclient.asynchronous.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

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
                                          @JsonProperty("user") String user) {}