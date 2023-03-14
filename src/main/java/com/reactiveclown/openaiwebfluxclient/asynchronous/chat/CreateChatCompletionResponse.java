package com.reactiveclown.openaiwebfluxclient.asynchronous.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reactiveclown.openaiwebfluxclient.asynchronous.Usage;

import java.util.List;

public record CreateChatCompletionResponse(@JsonProperty("id") String id,
                                           @JsonProperty("object") String object,
                                           @JsonProperty("created") Long created,
                                           @JsonProperty("choices") List<Choice> choices,
                                           @JsonProperty("usage") Usage usage) {
}

record Choice(@JsonProperty("index") Integer index,
              @JsonProperty("message") Message message,
              @JsonProperty("finish_reason") String finishReason) {

}
