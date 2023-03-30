package com.reactiveclown.openaiwebfluxclient.client.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "openai.api")
public record ClientConfigurationProperties(String apiKey,
                                            String organizationId,
                                            String baseUrl) {
    public ClientConfigurationProperties {
        if (baseUrl == null)
            baseUrl = "https://api.openai.com/v1";
    }
}