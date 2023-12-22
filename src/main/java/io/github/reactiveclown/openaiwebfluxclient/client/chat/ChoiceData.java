package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ChoiceData(@JsonProperty("index") Integer index,
                         @JsonProperty("logprobs") Logprobs logprobs,
                         @JsonAlias("delta") @JsonProperty("message") MessageData message,
                         @JsonProperty("finish_reason") String finishReason) {

}
