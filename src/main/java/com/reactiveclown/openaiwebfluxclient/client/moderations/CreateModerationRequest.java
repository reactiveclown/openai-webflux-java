package com.reactiveclown.openaiwebfluxclient.client.moderations;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateModerationRequest(@JsonProperty("input") String input,
                                      @JsonProperty("model") String model) {
}
