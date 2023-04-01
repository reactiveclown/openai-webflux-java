package io.github.reactiveclown.openaiwebfluxclient.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RetrieveModelResponse(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("created") Long created,
        @JsonProperty("owned_by") String ownedBy,
        @JsonProperty("permission") List<Permission> permission,
        @JsonProperty("root") String root,
        @JsonProperty("parent") String parent
) {}

record Permission(
        @JsonProperty("id") String id,
        @JsonProperty("object") String object,
        @JsonProperty("created") Long created,
        @JsonProperty("allow_create_engine") Boolean allowCreateEngine,
        @JsonProperty("allow_sampling") Boolean allowSampling,
        @JsonProperty("allow_logprobs") Boolean allowLogprobs,
        @JsonProperty("allow_search_indices") Boolean allowSearchIndices,
        @JsonProperty("allow_view") Boolean allowView,
        @JsonProperty("allow_fine_tuning") Boolean allowFineTuning,
        @JsonProperty("organization") String organization,
        @JsonProperty("group") String group,
        @JsonProperty("is_blocking") Boolean isBlocking
) {}
