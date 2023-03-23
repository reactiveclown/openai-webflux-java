package com.reactiveclown.openaiwebfluxclient.client.embeddings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.reactiveclown.openaiwebfluxclient.client.UsageData;

import java.util.List;

public record CreateEmbeddingsResponse(@JsonProperty("object") String object,
                                       @JsonProperty("data") List<EmbeddingData> data,
                                       @JsonProperty("model") String model,
                                       @JsonProperty("usage") UsageData usage) {
}

record EmbeddingData(@JsonProperty("object") String object,
                     @JsonProperty("embedding") List<Double> embedding,
                     @JsonProperty("index") Integer index) {

}
