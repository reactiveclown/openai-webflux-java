package io.github.reactiveclown.openaiwebfluxclient.requests;

import io.github.reactiveclown.openaiwebfluxclient.client.completions.CreateCompletionRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateCompletionRequestTest {
    @Test
    public void CreateCompletionRequestBuilder_test() {
        var builderRequest = new CreateCompletionRequest.Builder("model").build();
        var request = new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null,
                null, null, null,
                null, null, null,
                null);

        assertAll(() -> {
            assertEquals(request.prompt(), builderRequest.prompt());
            assertEquals(request.suffix(), builderRequest.suffix());
            assertEquals(request.maxTokens(), builderRequest.maxTokens());
            assertEquals(request.temperature(), builderRequest.temperature());
            assertEquals(request.topP(), builderRequest.topP());
            assertEquals(request.n(), builderRequest.n());
            assertEquals(request.logprobs(), builderRequest.logprobs());
            assertEquals(request.echo(), builderRequest.echo());
            assertEquals(request.stop(), builderRequest.stop());
            assertEquals(request.presencePenalty(), builderRequest.presencePenalty());
            assertEquals(request.frequencyPenalty(), builderRequest.frequencyPenalty());
            assertEquals(request.bestOf(), builderRequest.bestOf());
            assertEquals(request.logitBias(), builderRequest.logitBias());
            assertEquals(request.user(), builderRequest.user());
        });
    }


}
