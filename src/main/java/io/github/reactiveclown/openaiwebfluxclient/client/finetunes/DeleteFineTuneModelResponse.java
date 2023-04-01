package io.github.reactiveclown.openaiwebfluxclient.client.finetunes;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteFineTuneModelResponse(@JsonProperty("id") String id,
                                          @JsonProperty("object") String object,
                                          @JsonProperty("deleted") Boolean deleted) {
}
