package com.reactiveclown.openaiwebfluxclient;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.github.reactiveclown.openai")
public record ClientAutoConfigurationProperties(String apiKey,
                                                String organizationId,
                                                String baseUrl) {
    public ClientAutoConfigurationProperties{
        if (apiKey == null)
            throw new IllegalArgumentException("apiKey can't be null,"
                    + " please add com.github.reactiveclown.openai.apiKey property" +
                    " to the configuration");
        if (baseUrl == null)
            baseUrl = "https://api.openai.com/v1";
    }
}
