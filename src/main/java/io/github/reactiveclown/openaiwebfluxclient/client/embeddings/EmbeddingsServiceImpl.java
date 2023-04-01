package io.github.reactiveclown.openaiwebfluxclient.client.embeddings;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EmbeddingsServiceImpl implements EmbeddingsService {

    private final WebClient client;
    public EmbeddingsServiceImpl(WebClient client) {
        this.client = client;
    }

    @Override
    public Mono<CreateEmbeddingsResponse> createEmbeddings(CreateEmbeddingsRequest request) {
        String createEmbeddings = "/embeddings";
        return client.post()
                .uri(createEmbeddings)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateEmbeddingsResponse.class);
    }
}
