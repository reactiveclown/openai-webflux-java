package io.github.reactiveclown.openaiwebfluxclient.client.images;

/**
 * CreateImageVariationRequest.
 *
 * @param image          - The image to use as the basis for the variation(s).
 *                       Must be a valid PNG file, less than 4MB, and square.
 * @param n              - The number of images to generate. Must be between 1 and 10.
 * @param size           - The size of the generated images.
 *                       Must be one of 256x256, 512x512, or 1024x1024.
 * @param responseFormat - The format in which the generated images are returned.
 *                       Must be one of url or b64_json.
 * @param user           - A unique identifier representing your end-user,
 *                       which can help OpenAI to monitor and detect abuse.
 */
public record CreateImageVariationRequest(String image,
                                          Integer n,
                                          String size,
                                          String responseFormat,
                                          String user) {

    public CreateImageVariationRequest {
        if (image == null || image.isBlank())
            throw new IllegalArgumentException("image value can't be null or blank");
    }

    public static Builder builder(String image) {
        return new Builder(image);
    }

    public static final class Builder {
        String image;
        Integer n;
        String size;
        String responseFormat;
        String user;

        public CreateImageVariationRequest build() {
            return new CreateImageVariationRequest(
                    image, n, size,
                    responseFormat, user);
        }

        public Builder(String image) {
            this.image = image;
        }

        public Builder n(Integer n) {
            this.n = n;
            return this;
        }

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder responseFormat(String responseFormat) {
            this.responseFormat = responseFormat;
            return this;
        }

        public Builder user(String user) {
            this.user = user;
            return this;
        }
    }
}
