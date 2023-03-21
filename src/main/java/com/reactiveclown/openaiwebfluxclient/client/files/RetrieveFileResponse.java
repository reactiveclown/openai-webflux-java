package com.reactiveclown.openaiwebfluxclient.client.files;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RetrieveFileResponse(@JsonProperty("id") String id,
                                   @JsonProperty("object") String object,
                                   @JsonProperty("bytes") Integer bytes,
                                   @JsonProperty("created_at") Long createdAt,
                                   @JsonProperty("filename") String filename,
                                   @JsonProperty("purpose") String purpose) {
}
