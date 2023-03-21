package com.reactiveclown.openaiwebfluxclient.client.files;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ListFilesResponse(@JsonProperty("data") List<FileData> data,
                                @JsonProperty("object") String object) {
}

record FileData(@JsonProperty("id") String id,
                @JsonProperty("object") String object,
                @JsonProperty("bytes") Integer bytes,
                @JsonProperty("created_at") Long createdAt,
                @JsonProperty("filename") String filename,
                @JsonProperty("purpose") String purpose) {
}
