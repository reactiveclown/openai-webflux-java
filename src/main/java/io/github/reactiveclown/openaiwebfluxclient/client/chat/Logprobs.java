package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Logprobs(@JsonProperty("content") List<Content> content) {
}
