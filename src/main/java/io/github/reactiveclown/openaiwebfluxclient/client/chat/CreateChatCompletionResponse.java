package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.reactiveclown.openaiwebfluxclient.client.UsageData;

import java.util.List;

public record CreateChatCompletionResponse(@JsonProperty("id") String id,
                                           @JsonProperty("object") String object,
                                           @JsonProperty("created") Long created,
                                           @JsonProperty("model") String model,
                                           @JsonProperty("choices") List<ChoiceData> choices,
                                           @JsonProperty("usage") UsageData usage) {
}

