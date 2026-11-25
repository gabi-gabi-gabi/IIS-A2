package com.a2.iis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendationResponse {
    private boolean conflict;
    private String eventToMove;
    private String suggestedTime;
    private String explanation;
    private String risk;
}