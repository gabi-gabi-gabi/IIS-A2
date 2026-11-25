package com.a2.iis.service;

import com.a2.iis.model.AgentMode;
import org.springframework.stereotype.Service;

@Service
public class ModeService {
    private AgentMode currentMode = AgentMode.SUGGESTION;
    public AgentMode getMode() {
        return currentMode;
    }
    public void setMode(AgentMode mode) {
        this.currentMode = mode;
    }
}
