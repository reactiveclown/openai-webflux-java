package com.reactiveclown.openaiwebfluxclient.client.embeddings;

import com.reactiveclown.openaiwebfluxclient.client.Usage;

import java.util.List;

public record CreateEmbeddingsResponse(String object,
                                       List<Embedding> data,
                                       String model,
                                       Usage usage) {
}

record Embedding(String object,
                 List<Double> embedding,
                 Integer index) {

}
