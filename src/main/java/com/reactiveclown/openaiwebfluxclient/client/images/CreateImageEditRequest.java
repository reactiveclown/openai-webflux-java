package com.reactiveclown.openaiwebfluxclient.client.images;

/**
 * CreateImageEditRequest.
 *
 * @param image          - The image to edit. Must be a valid PNG file, less than 4MB, and square.
 *                       If mask is not provided, image must have transparency, which will be used as the mask.
 * @param mask           - An additional image whose fully transparent areas (e.g. where alpha is zero)
 *                       indicate where image should be edited. Must be a valid PNG file,
 *                       less than 4MB, and have the same dimensions as image.
 * @param prompt         - A text description of the desired image(s). The maximum length is 1000 characters.
 * @param n              - The number of images to generate. Must be between 1 and 10.
 * @param size           - The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024.
 * @param responseFormat - The format in which the generated images are returned. Must be one of url or b64_json.
 * @param user           - A unique identifier representing your end-user,
 *                       which can help OpenAI to monitor and detect abuse
 */
public record CreateImageEditRequest(String image,
                                     String mask,
                                     String prompt,
                                     Integer n,
                                     String size,
                                     String responseFormat,
                                     String user) {

    public CreateImageEditRequest {
        if (image == null || image.isBlank())
            throw new IllegalArgumentException("image value can't be null or blank");

        if (prompt == null || prompt.isEmpty())
            throw new IllegalArgumentException("prompt value can't be null or empty");
    }

    public static Builder builder(String image, String prompt) {
        return new Builder(image, prompt);
    }

    public static final class Builder {
        String image;
        String mask;
        String prompt;
        Integer n;
        String size;
        String responseFormat;
        String user;

        public CreateImageEditRequest build() {
            return new CreateImageEditRequest(
                    image, mask, prompt,
                    n, size, responseFormat,
                    user);
        }

        public Builder(String image, String prompt) {
            this.image = image;
            this.prompt = prompt;
        }

        public Builder mask(String mask) {
            this.mask = mask;
            return this;
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

