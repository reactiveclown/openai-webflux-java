package com.reactiveclown.openaiwebfluxclient.client.files;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UploadFileRequest(@JsonProperty("file") String file,
                                @JsonProperty("purpose") String purpose) {
    public UploadFileRequest {
        if (file == null || file.isEmpty())
            throw new IllegalArgumentException("file value can't be null or empty");

        if (purpose == null || purpose.isEmpty())
            throw new IllegalArgumentException("purpose value can't be null or empty");
    }

    public static final class Builder{
        String file;
        String purpose;

        public UploadFileRequest build(){
            return new UploadFileRequest(file, purpose);
        }

        public Builder(String file, String purpose){
            this.file = file;
            this.purpose = purpose;
        }
    }
}
