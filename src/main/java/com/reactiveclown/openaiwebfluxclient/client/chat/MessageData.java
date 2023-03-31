package com.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MessageData(@JsonProperty("role") String role,
                   @JsonProperty("content") String content){}
