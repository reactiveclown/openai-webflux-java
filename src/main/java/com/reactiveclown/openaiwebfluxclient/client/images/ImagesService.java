package com.reactiveclown.openaiwebfluxclient.client.images;

import reactor.core.publisher.Mono;

public interface ImagesService {

    /**
     * Creates an image given a prompt.
     *
     * @param request {@link CreateImageRequest}
     * @return A Mono of {@link CreateImageResponse}
     */
    Mono<CreateImageResponse> createImage(CreateImageRequest request);

    /**
     * Creates an edited or extended image given an original image and a prompt.
     *
     * @param request {@link CreateImageEditRequest}
     * @return A Mono of {@link CreateImageEditResponse}
     */
    Mono<CreateImageEditResponse> createImageEdit(CreateImageEditRequest request);

    /**
     * Creates a variation of a given image.
     *
     * @param request {@link CreateImageVariationRequest}
     * @return A Mono of {@link CreateImageVariationResponse}
     */
    Mono<CreateImageVariationResponse> createImageVariation(CreateImageVariationRequest request);
}
