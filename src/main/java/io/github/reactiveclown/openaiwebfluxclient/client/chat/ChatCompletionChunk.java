package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ChatCompletionChunk(@JsonProperty("id") String id,
                                  @JsonProperty("object") String object,
                                  @JsonProperty("created") Long created,
                                  @JsonProperty("model") String model,
                                  @JsonProperty("system_fingerprint") String systemFingerprint,
                                  @JsonProperty("choices") List<ChoiceData> choices) {
}
