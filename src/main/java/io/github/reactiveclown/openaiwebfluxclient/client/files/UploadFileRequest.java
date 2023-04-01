package io.github.reactiveclown.openaiwebfluxclient.client.files;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UploadFileRequest.
 *
 * @param file    - Name of the JSON Lines file to be uploaded.
 *                <p>
 *                If the purpose is set to "fine-tune",
 *                each line is a JSON record with "prompt" and "completion" fields representing your training examples.
 * @param purpose - The intended purpose of the uploaded documents.
 *                <p>
 *                Use "fine-tune" for Fine-tuning. This allows us to validate the format of the uploaded file.
 */
public record UploadFileRequest(@JsonProperty("file") String file,
                                @JsonProperty("purpose") String purpose) {
    public UploadFileRequest {
        if (file == null || file.isEmpty())
            throw new IllegalArgumentException("file value can't be null or empty");

        if (purpose == null || purpose.isEmpty())
            throw new IllegalArgumentException("purpose value can't be null or empty");
    }

    public static Builder builder(String file, String purpose) {
        return new Builder(file, purpose);
    }

    public static final class Builder {
        String file;
        String purpose;

        public UploadFileRequest build() {
            return new UploadFileRequest(file, purpose);
        }

        public Builder(String file, String purpose) {
            this.file = file;
            this.purpose = purpose;
        }
    }
}
