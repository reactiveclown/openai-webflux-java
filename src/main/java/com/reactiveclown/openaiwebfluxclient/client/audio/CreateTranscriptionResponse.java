package com.reactiveclown.openaiwebfluxclient.client.audio;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateTranscriptionResponse(@JsonProperty("text") String text) {
}
