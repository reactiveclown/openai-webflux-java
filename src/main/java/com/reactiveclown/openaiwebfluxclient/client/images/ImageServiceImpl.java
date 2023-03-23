package com.reactiveclown.openaiwebfluxclient.client.images;

import org.springframework.core.io.PathResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ImageServiceImpl implements ImagesService {

    private final WebClient client;

    public ImageServiceImpl(WebClient client) {
        this.client = client;
    }

    @Override
    public Mono<CreateImageResponse> createImage(CreateImageRequest request) {
        String createImageUrl = "/images/generations";
        return client.post()
                .uri(createImageUrl)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateImageResponse.class);
    }

    @Override
    public Mono<CreateImageEditResponse> createImageEdit(CreateImageEditRequest request) {
        String createImageEditUrl = "/images/edits";
        var multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("image", new PathResource(request.image()));
        multipartBodyBuilder.part("prompt", request.prompt());

        if (request.mask() != null)
            multipartBodyBuilder.part("mask", new PathResource(request.mask()));

        if (request.n() != null)
            multipartBodyBuilder.part("n", request.n());

        if (request.size() != null)
            multipartBodyBuilder.part("size", request.size());

        if (request.responseFormat() != null)
            multipartBodyBuilder.part("response_format", request.responseFormat());

        if (request.user() != null)
            multipartBodyBuilder.part("user", request.user());

        return client.post()
                .uri(createImageEditUrl)
                .bodyValue(multipartBodyBuilder.build())
                .retrieve()
                .bodyToMono(CreateImageEditResponse.class);
    }

    @Override
    public Mono<CreateImageVariationResponse> createImageVariation(CreateImageVariationRequest request) {
        String createImageVariation = "/images/variations";
        var multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("image", new PathResource(request.image()));
        multipartBodyBuilder.part("n", request.n());
        multipartBodyBuilder.part("size", request.size());
        multipartBodyBuilder.part("response_format", request.responseFormat());
        multipartBodyBuilder.part("user", request.user());

        return client.post()
                .uri(createImageVariation)
                .bodyValue(multipartBodyBuilder.build())
                .retrieve()
                .bodyToMono(CreateImageVariationResponse.class);
    }
}
