package com.reactiveclown.openaiwebfluxclient.client.images;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public record CreateImageResponse(@JsonProperty("created") Long created,
                                  @JsonProperty("data") List<Map<String, String>> data) {
}
