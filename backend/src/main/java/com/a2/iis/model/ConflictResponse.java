package com.a2.iis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConflictResponse {
    private boolean conflict;
    private String eventA;
    private String eventB;
    private String message;
}
