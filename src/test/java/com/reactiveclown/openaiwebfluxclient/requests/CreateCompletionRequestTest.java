package com.reactiveclown.openaiwebfluxclient.requests;

import com.reactiveclown.openaiwebfluxclient.client.completions.CreateCompletionRequest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCompletionRequestTest {

    @Test
    public void CreateCompletionRequest_defaultValues_test() {
        var request = new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null);
        assertAll(() -> {
            assertEquals("<|endoftext|>", request.prompt().get(0).get(0));
            assertNull(request.suffix());
            assertEquals(16, request.maxTokens());
            assertEquals(1.0, request.temperature());
            assertEquals(1.0, request.topP());
            assertEquals(1, request.n());
            assertEquals(false, request.stream());
            assertNull(request.logprobs());
            assertEquals(false, request.echo());
            assertNull(request.stop());
            assertEquals(0.0, request.presencePenalty());
            assertEquals(0.0, request.frequencyPenalty());
            assertEquals(1, request.bestOf());
            assertEquals(Collections.emptyMap(), request.logitBias());
            assertEquals("", request.user());
        });
    }

    @Test
    public void CreateCompletionRequest_modelNullRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                null, null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null));

        assertEquals("model value can't be null or blank", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_modelEmptyRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "", null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null));

        assertEquals("model value can't be null or blank", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_modelBlankRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                " ", null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null));

        assertEquals("model value can't be null or blank", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_temperatureLessThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, -1.0, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null));

        assertEquals("temperature value should be between [0.0, 2.0]", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_temperatureMoreThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, 3.0, null,
                null, null, null,
                null, null, null,
                null, null, null,
                null));

        assertEquals("temperature value should be between [0.0, 2.0]", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_topPMoreThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, null, 2.0,
                null, null, null,
                null, null, null,
                null, null, null,
                null));

        assertEquals("topP value should be between [0.0, 1.0]", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_topPLessThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, null, -1.0,
                null, null, null,
                null, null, null,
                null, null, null,
                null));

        assertEquals("topP value should be between [0.0, 1.0]", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_logprobsLessThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null, -1,
                null, null, null,
                null, null, null,
                null));

        assertEquals("logprobs value should be greater than 0.0", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_stopSizeMoreThanRestriction_test() {
        var stop = List.of("1", "2", "3", "4", "5");
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null, null,
                null, stop, null,
                null, null, null,
                null));

        assertEquals("stop size can't be greater than 4", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_presencePenaltyMoreThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null, null,
                null, null, 3.0,
                null, null, null,
                null));

        assertEquals("presencePenalty value should be between [-2.0, 2.0]", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_presencePenaltyLessThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null, null,
                null, null, -3.0,
                null, null, null,
                null));

        assertEquals("presencePenalty value should be between [-2.0, 2.0]", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_frequencyPenaltyMoreThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                3.0, null, null,
                null));

        assertEquals("frequencyPenalty value should be between [-2.0, 2.0]", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequest_frequencyPenaltyLessThanRestriction_test() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null, null,
                null, null, null,
                -3.0, null, null,
                null));

        assertEquals("frequencyPenalty value should be between [-2.0, 2.0]", exception.getMessage());
    }

    @Test
    public void CreateCompletionRequestBuilder_test() {
        var builderRequest = new CreateCompletionRequest.Builder("model").build();
        var request = new CreateCompletionRequest(
                "model", null, null,
                null, null, null,
                null, null, null,
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
            assertEquals(request.stream(), builderRequest.stream());
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
