package com.reactiveclown.openaiwebfluxclient.asynchronous.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

record Message(@JsonProperty("role") String role,
               @JsonProperty("content") String content){}
