package com.reactiveclown.openaiwebfluxclient.client.audio;

public record CreateTranslationRequest(String file,
                                       String model,
                                       String prompt,
                                       String responseFormat,
                                       Double temperature) {
    public CreateTranslationRequest {
        //Providing the default values
        if (responseFormat == null) responseFormat = "json";
        if (temperature == null) temperature = 0.0;

        //Checking the restrictions
        if (file == null || file.isEmpty())
            throw new IllegalArgumentException("file value can't be null or empty");

        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");

        if (!responseFormat.equals("json") && !responseFormat.equals("text")
                && !responseFormat.equals("srt") && !responseFormat.equals("verbose_json")
                && !responseFormat.equals("vtt"))
            throw new IllegalArgumentException("responseFormat value must be one of " +
                    "\"json\", \"text\", \"srt\", \"verbose_json\", or \"vtt\".");

        if (temperature > 2.0 || temperature < 0.0)
            throw new IllegalArgumentException("temperature value should be between [0.0, 2.0]");
    }

    public static final class Builder {
        String file;
        String model;
        String prompt;
        String responseFormat;
        Double temperature;

        public CreateTranslationRequest build() {
            return new CreateTranslationRequest(
                    file, model, prompt,
                    responseFormat, temperature);
        }

        public Builder(String file, String model) {
            this.file = file;
            this.model = model;
        }

        public Builder prompt(String prompt) {
            this.prompt = prompt;
            return this;
        }

        public Builder responseFormat(String responseFormat) {
            this.responseFormat = responseFormat;
            return this;
        }


        public Builder temperature(Double temperature) {
            this.temperature = temperature;
            return this;
        }
    }

}