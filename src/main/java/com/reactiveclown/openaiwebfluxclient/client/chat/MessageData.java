package com.reactiveclown.openaiwebfluxclient.client.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

record MessageData(@JsonProperty("role") String role,
                   @JsonProperty("content") String content){}
