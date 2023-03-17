package com.reactiveclown.openaiwebfluxclient.client.images;

public record CreateImageVariationRequest(String image,
                                          Integer n,
                                          String size,
                                          String responseFormat,
                                          String user) {

    public CreateImageVariationRequest{
        //Providing the default values
        if (n == null) n = 1;
        if (size == null) size = "1024x1024";
        if (responseFormat == null) responseFormat = "url";
        if (user == null) user = "";

        //Checking the restrictions
        if (n > 10 || n < 1)
            throw new IllegalArgumentException("n value should be between [1, 10]");

        if (!size.equals("1024x1024") && !size.equals("256x256") && !size.equals("512x512"))
            throw new IllegalArgumentException("size value must be one of \"256x256\", \"512x512\", or \"1024x1024\"");

        if (!responseFormat.equals("url") && !responseFormat.equals("b64_json"))
            throw new IllegalArgumentException("responseFormat value must be one of \"url\" or \"b64_json\"");
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
