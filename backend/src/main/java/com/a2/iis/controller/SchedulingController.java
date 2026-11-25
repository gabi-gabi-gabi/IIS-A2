package com.a2.iis.controller;

import com.a2.iis.model.ConflictResponse;
import com.a2.iis.model.RecommendationResponse;
import com.a2.iis.service.CalendarService;
import com.a2.iis.service.SchedulingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulingController {
    private final CalendarService calendarService;
    private final SchedulingService schedulingService;
    public SchedulingController(
            CalendarService calendarService,
            SchedulingService schedulingService
    ) {
        this.calendarService = calendarService;
        this.schedulingService = schedulingService;
    }
    @GetMapping("/conflicts")
    public ConflictResponse detectConflicts() {
        return schedulingService.detectConflict(calendarService.getEvents());
    }
    @GetMapping("/recommendation")
    public RecommendationResponse getRecommendation() {
        return schedulingService.generateRecommendation(calendarService.getEvents());
    }
}