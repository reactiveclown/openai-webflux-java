package io.github.reactiveclown.openaiwebfluxclient.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsageData(@JsonProperty("prompt_tokens") Integer promptTokens,
                        @JsonProperty("completion_tokens") Integer completionTokens,
                        @JsonProperty("total_tokens") Integer total_tokens) {
}
