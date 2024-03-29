package io.github.reactiveclown.openaiwebfluxclient.client.finetunes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RetrieveFineTuneResponse(@JsonProperty("id") String id,
                                       @JsonProperty("object") String object,
                                       @JsonProperty("model") String model,
                                       @JsonProperty("created_at") Long createdAt,
                                       @JsonProperty("events") List<FineTuneEventData> events) {
}

record FineTuneEventData(@JsonProperty("object") String object,
                         @JsonProperty("created_at") Long createdAt,
                         @JsonProperty("level") String level,
                         @JsonProperty("message") String message) {

}
