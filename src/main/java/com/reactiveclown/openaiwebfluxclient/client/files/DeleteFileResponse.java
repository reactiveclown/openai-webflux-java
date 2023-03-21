package com.reactiveclown.openaiwebfluxclient.client.files;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DeleteFileResponse(@JsonProperty("id") String id,
                                 @JsonProperty("object") String object,
                                 @JsonProperty("deleted") Boolean deleted) {
}
