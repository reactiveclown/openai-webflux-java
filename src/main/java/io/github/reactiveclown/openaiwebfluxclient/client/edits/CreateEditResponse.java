package io.github.reactiveclown.openaiwebfluxclient.client.edits;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.reactiveclown.openaiwebfluxclient.client.UsageData;

import java.util.List;

public record CreateEditResponse(@JsonProperty("object") String object,
                                 @JsonProperty("created") Long created,
                                 @JsonProperty("choices") List<ChoiceData> choices,
                                 @JsonProperty("usage") UsageData usage) {
}

record ChoiceData(@JsonProperty("text") String text,
                  @JsonProperty("index") Integer index) {
}
