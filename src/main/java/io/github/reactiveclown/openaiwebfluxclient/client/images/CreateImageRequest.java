package io.github.reactiveclown.openaiwebfluxclient.client.images;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CreateImageRequest.
 *
 * @param prompt         - A text description of the desired image(s).
 *                       The maximum length is 1000 characters.
 * @param n              - The number of images to generate.
 *                       Must be between 1 and 10.
 * @param size           - The size of the generated images.
 *                       Must be one of 256x256, 512x512, or 1024x1024.
 * @param responseFormat - The format in which the generated images are returned.
 *                       Must be one of url or b64_json.
 * @param user           - A unique identifier representing your end-user,
 *                       which can help OpenAI to monitor and detect abuse.
 */
@JsonInclude(Include.NON_NULL)
public record CreateImageRequest(@JsonProperty("prompt") String prompt,
                                 @JsonProperty("n") Integer n,
                                 @JsonProperty("size") String size,
                                 @JsonProperty("response_format") String responseFormat,
                                 @JsonProperty("user") String user) {
    public CreateImageRequest {
        if (prompt == null || prompt.isEmpty())
            throw new IllegalArgumentException("prompt value can't be null or empty");
    }

    public static Builder builder(String prompt) {
        return new Builder(prompt);
    }

    public static final class Builder {
        String prompt;
        Integer n;
        String size;
        String responseFormat;
        String user;

        public CreateImageRequest build() {
            return new CreateImageRequest(
                    prompt, n, size,
                    responseFormat, user);
        }

        public Builder(String prompt) {
            this.prompt = prompt;
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
