package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChoiceData(@JsonProperty("index") Integer index,
                         @JsonProperty("message") MessageData message,
                         @JsonProperty("finish_reason") String finishReason) {

}
