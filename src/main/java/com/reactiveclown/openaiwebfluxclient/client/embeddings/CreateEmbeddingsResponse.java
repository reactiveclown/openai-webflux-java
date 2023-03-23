package com.reactiveclown.openaiwebfluxclient.client.embeddings;

import com.reactiveclown.openaiwebfluxclient.client.UsageData;

import java.util.List;

public record CreateEmbeddingsResponse(String object,
                                       List<Embedding> data,
                                       String model,
                                       UsageData usage) {
}

record Embedding(String object,
                 List<Double> embedding,
                 Integer index) {

}
