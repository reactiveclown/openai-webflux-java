package io.github.reactiveclown.openaiwebfluxclient.client.models;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ModelsServiceImpl implements ModelsService{
    private final WebClient client;
    public ModelsServiceImpl(WebClient client){
        this.client = client;
    }
    @Override
    public Mono<ListModelsResponse> listModels() {
        String listModelsUri = "/models";
        return client.get()
                .uri(listModelsUri)
                .retrieve()
                .bodyToMono(ListModelsResponse.class);
    }

    @Override
    public Mono<RetrieveModelResponse> retrieveModel(String model) {
        String retrieveModelUri = String.format("/models/%s", model);
        return client.get()
                .uri(retrieveModelUri)
                .retrieve()
                .bodyToMono(RetrieveModelResponse.class);
    }
}
