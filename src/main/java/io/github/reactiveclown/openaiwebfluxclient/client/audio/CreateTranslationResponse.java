package io.github.reactiveclown.openaiwebfluxclient.client.audio;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateTranslationResponse(@JsonProperty("text") String text) {
}
