package io.github.reactiveclown.openaiwebfluxclient.exception;

import org.springframework.web.reactive.function.client.WebClientException;

public class OpenAiException extends WebClientException {
    public OpenAiException(Integer statusCode, String errorMessage) {
        super(String.format("""
                        
                        OpenAi Service exception occurred.
                        HTTP error code: %s
                        Detailed error message:
                        %s
                        """,
                statusCode, errorMessage));
    }
}
