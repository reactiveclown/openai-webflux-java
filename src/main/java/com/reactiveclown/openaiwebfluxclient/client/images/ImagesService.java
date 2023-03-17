package com.reactiveclown.openaiwebfluxclient.client.images;

import reactor.core.publisher.Mono;

public interface ImagesService {

    Mono<CreateImageResponse> createImage(CreateImageRequest request);

    Mono<CreateImageEditResponse> createImageEdit(CreateImageEditRequest request);

    Mono<CreateImageVariationResponse> createImageVariation(CreateImageVariationRequest request);
}
