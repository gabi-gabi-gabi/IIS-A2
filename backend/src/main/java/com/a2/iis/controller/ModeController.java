package com.a2.iis.controller;

import com.a2.iis.model.AgentMode;
import com.a2.iis.model.ModeRequest;
import com.a2.iis.service.ModeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModeController {
    private final ModeService modeService;
    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }
    @GetMapping("/mode")
    public AgentMode getMode() {
        return modeService.getMode();
    }
    @PostMapping("/mode")
    public AgentMode setMode(
            @RequestBody ModeRequest request
    ) {
        modeService.setMode(request.getMode());
        return modeService.getMode();
    }
}