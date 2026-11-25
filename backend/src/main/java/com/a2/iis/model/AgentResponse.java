package com.a2.iis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AgentResponse {
    private String mode;
    private String action;
    private String message;
    private boolean executed;
    private String explanation;
    private String risk;
}