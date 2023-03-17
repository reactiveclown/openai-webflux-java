package com.reactiveclown.openaiwebfluxclient.client.images;

import org.springframework.core.io.PathResource;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.File;

@Service
public class ImageServiceImpl implements ImagesService{

    private final WebClient client;

    public ImageServiceImpl(WebClient client){
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
        if (request.mask() != null){
            multipartBodyBuilder.part("mask", new PathResource(request.mask()));
        }
        multipartBodyBuilder.part("prompt", request.prompt());
        multipartBodyBuilder.part("n", request.n());
        multipartBodyBuilder.part("size", request.size());
        multipartBodyBuilder.part("response_format", request.responseFormat());
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
