package io.github.reactiveclown.openaiwebfluxclient.client.audio;

/**
 * CreateTranscriptionRequest.
 *
 * @param file           - The audio file to transcribe,
 *                       in one of these formats: mp3, mp4, mpeg, mpga, m4a, wav, or webm.
 * @param model          - ID of the model to use. Only whisper-1 is currently available.
 * @param prompt         - An optional text to guide the model's style or continue a previous audio segment.
 *                       The prompt should match the audio language.
 * @param responseFormat - The format of the transcript output,
 *                       in one of these options: json, text, srt, verbose_json, or vtt.
 * @param temperature    - The sampling temperature, between 0 and 1.
 *                       Higher values like 0.8 will make the output more random,
 *                       while lower values like 0.2 will make it more focused and deterministic.
 *                       If set to 0, the model will use log probability to automatically increase
 *                       the temperature until certain thresholds are hit.
 * @param language       - The language of the input audio.
 *                       Supplying the input language in ISO-639-1 format will improve accuracy and latency.
 */
public record CreateTranscriptionRequest(String file,
                                         String model,
                                         String prompt,
                                         String responseFormat,
                                         Double temperature,
                                         String language) {

    public CreateTranscriptionRequest {
        if (file == null || file.isEmpty())
            throw new IllegalArgumentException("file value can't be null or empty");

        if (model == null || model.isBlank())
            throw new IllegalArgumentException("model value can't be null or blank");
    }

    public static Builder builder(String file, String model) {
        return new Builder(file, model);
    }

    public static final class Builder {
        String file;
        String model;
        String prompt;
        String responseFormat;
        Double temperature;
        String language;

        public CreateTranscriptionRequest build() {
            return new CreateTranscriptionRequest(
                    file, model, prompt,
                    responseFormat, temperature, language);
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

        public Builder language(String language) {
            this.language = language;
            return this;
        }
    }
}
