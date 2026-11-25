package com.a2.iis.controller;

import com.a2.iis.model.AgentResponse;
import com.a2.iis.service.AgentService;
import com.a2.iis.service.CalendarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class AgentController {
    private final AgentService agentService;
    private final CalendarService calendarService;
    public AgentController(AgentService agentService, CalendarService calendarService) {
        this.agentService = agentService;
        this.calendarService = calendarService;
    }
    @GetMapping("/agent")
    public AgentResponse process() {
        return agentService.process();
    }
    @PostMapping("/agent/approve")
    public String approve() {
        agentService.approve();
        return "Approved";
    }
    @PostMapping("/undo")
    public String undo() {
        calendarService.undo();
        return "Undo successful";
    }
}