package com.reactiveclown.openaiwebfluxclient.client.completions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reactiveclown.openaiwebfluxclient.client.Usage;

import java.util.List;
import java.util.Map;

public record CreateCompletionResponse(@JsonProperty("id") String id,
                                       @JsonProperty("object") String object,
                                       @JsonProperty("created") Long created,
                                       @JsonProperty("model") String model,
                                       @JsonProperty("choices") List<Choice> choices,
                                       @JsonProperty("usage") Usage usage) {
}

record Choice(@JsonProperty("text") String text,
              @JsonProperty("index") Integer index,
              @JsonProperty("logprobs") Logprobs logprobs,
              @JsonProperty("finish_reason") String finishReason) {
}

record Logprobs(@JsonProperty("tokens") List<String> tokens,
                @JsonProperty("token_logprobs") List<Double> tokenLogprobs,
                @JsonProperty("top_logprobs") List<Map<String, Double>> topLogprobs,
                @JsonProperty("text_offset") List<Integer> textOffset) {
}