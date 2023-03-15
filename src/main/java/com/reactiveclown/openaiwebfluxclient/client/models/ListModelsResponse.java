package com.reactiveclown.openaiwebfluxclient.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ListModelsResponse(
        @JsonProperty("object") String object,
        @JsonProperty("data") List<RetrieveModelResponse> data
) {}