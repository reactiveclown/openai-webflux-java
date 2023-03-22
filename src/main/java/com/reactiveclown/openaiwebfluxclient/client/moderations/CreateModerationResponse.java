package com.reactiveclown.openaiwebfluxclient.client.moderations;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreateModerationResponse(@JsonProperty("id") String id,
                                       @JsonProperty("model")String model,
                                       @JsonProperty("results")List<ModerationData> results) {
}

record ModerationData(@JsonProperty("categories")ModerationCategoriesData categories,
                      @JsonProperty("category_scores")ModerationCategoriesScoresData categoryScores,
                      @JsonProperty("flagged")Boolean flagged) {
}

record ModerationCategoriesData(@JsonProperty("hate")Boolean hate,
                                @JsonProperty("hate/threatening")Boolean hateThreatening,
                                @JsonProperty("self-harm")Boolean selfHarm,
                                @JsonProperty("sexual")Boolean sexual,
                                @JsonProperty("sexual/minors")Boolean sexualMinors,
                                @JsonProperty("violence")Boolean violence,
                                @JsonProperty("violence/graphic")Boolean violenceGraphic) {

}

record ModerationCategoriesScoresData(@JsonProperty("hate")Double hate,
                                      @JsonProperty("hate/threatening")Double hateThreatening,
                                      @JsonProperty("self-harm")Double selfHarm,
                                      @JsonProperty("sexual")Double sexual,
                                      @JsonProperty("sexual/minors")Double sexualMinors,
                                      @JsonProperty("violence")Double violence,
                                      @JsonProperty("violence/graphic")Double violenceGraphic) {
}