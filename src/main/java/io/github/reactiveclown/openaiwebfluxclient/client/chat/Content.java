package io.github.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record Content(@JsonProperty("token") String token,
                      @JsonProperty("logprob") Integer logprob,
                      @JsonProperty("bytes") List<Integer> bytes,
                      @JsonProperty("top_logprobs") List<Content> topLogprobs) {
}
