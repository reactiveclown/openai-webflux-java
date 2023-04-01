package io.github.reactiveclown.openaiwebfluxclient.client.finetunes;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class FineTuneServiceImpl implements FineTunesService {

    private final WebClient client;

    public FineTuneServiceImpl(WebClient client) {
        this.client = client;
    }

    @Override
    public Mono<CreateFineTuneResponse> createFineTune(CreateFineTuneRequest request) {
        String createFineTuneUrl = "/fine-tunes";
        return client.post()
                .uri(createFineTuneUrl)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateFineTuneResponse.class);
    }

    @Override
    public Mono<ListFineTunesResponse> listFineTunes() {
        String listFineTunesUrl = "/fine-tunes";
        return client.get()
                .uri(listFineTunesUrl)
                .retrieve()
                .bodyToMono(ListFineTunesResponse.class);
    }

    @Override
    public Mono<RetrieveFineTuneResponse> retrieveFineTunes(String fineTuneId) {
        String retrieveFineTunesUrl = String.format("/fine-tunes/%s", fineTuneId);
        return client.get()
                .uri(retrieveFineTunesUrl)
                .retrieve()
                .bodyToMono(RetrieveFineTuneResponse.class);
    }

    @Override
    public Mono<CancelFineTuneResponse> cancelFineTune(String fineTuneId) {
        String cancelFineTuneUrl = String.format("/fine-tunes/%s/cancel", fineTuneId);
        return client.post()
                .uri(cancelFineTuneUrl)
                .retrieve()
                .bodyToMono(CancelFineTuneResponse.class);
    }

    @Override
    public Mono<ListFineTuneEventsResponse> listFineTuneEvents(String fineTuneId) {
        String listFineTuneEvents = String.format("/fine-tunes/%s/events", fineTuneId);
        return client.get()
                .uri(listFineTuneEvents)
                .retrieve()
                .bodyToMono(ListFineTuneEventsResponse.class);
    }

    @Override
    public Mono<DeleteFineTuneModelResponse> deleteFineTuneModel(String model) {
        String deleteFineTuneModelUrl = String.format("/models/%s", model);
        return client.delete()
                .uri(deleteFineTuneModelUrl)
                .retrieve()
                .bodyToMono(DeleteFineTuneModelResponse.class);
    }
}
