package com.reactiveclown.openaiwebfluxclient.client.finetunes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ListFineTuneEventsResponse(@JsonProperty("object") String object,
                                         @JsonProperty("data") List<FineTuneEventData> data) {
}
