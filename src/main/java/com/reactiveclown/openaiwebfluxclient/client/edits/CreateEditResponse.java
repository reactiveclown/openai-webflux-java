package com.reactiveclown.openaiwebfluxclient.client.edits;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reactiveclown.openaiwebfluxclient.client.Usage;

import java.util.List;

public record CreateEditResponse(@JsonProperty("object") String object,
                                 @JsonProperty("created") Long created,
                                 @JsonProperty("choices") List<Choice> choices,
                                 @JsonProperty("usage") Usage usage) {
}

record Choice(@JsonProperty("text") String text,
              @JsonProperty("index") Integer index) {
}
