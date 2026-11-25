package com.a2.iis.service;

import com.a2.iis.model.AgentMode;
import com.a2.iis.model.AgentResponse;
import com.a2.iis.model.RecommendationResponse;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    private final ModeService modeService;
    private final SchedulingService schedulingService;
    private final CalendarService calendarService;
    public AgentService(ModeService modeService, SchedulingService schedulingService, CalendarService calendarService) {
        this.modeService = modeService;
        this.schedulingService = schedulingService;
        this.calendarService = calendarService;
    }
    public AgentResponse process() {
        RecommendationResponse recommendation = schedulingService.generateRecommendation(calendarService.getEvents());
        AgentMode mode = modeService.getMode();
        if (!recommendation.isConflict()) {
            return new AgentResponse(
                    mode.name(),
                    "NONE",
                    "No conflicts detected",
                    false,
                    "",
                    "NONE"
            );
        }
        switch (mode) {
            case SUGGESTION:
                return new AgentResponse(
                        mode.name(),
                        "SUGGEST",
                        recommendation.getExplanation(),
                        false,
                        "Gym and Study are scheduled at the same time. Recommending moving Study to remove conflict.",
                        recommendation.getRisk()
                );
            case APPROVAL:
                pendingRecommendation = recommendation;
                return new AgentResponse(
                        mode.name(),
                        "WAITING_APPROVAL",
                        recommendation.getExplanation(),
                        false,
                        "Gym and Study are scheduled at the same time. Requesting approval to move Study.",
                        recommendation.getRisk()
                );
            case AUTONOMOUS:
                calendarService.moveEvent(recommendation.getEventToMove(), recommendation.getSuggestedTime());
                return new AgentResponse(
                        mode.name(),
                        "AUTO_APPLY",
                        recommendation.getExplanation(),
                        true,
                        "Agent automatically applied changes in autonomous mode.",
                        recommendation.getRisk()
                );
            default:
                throw new RuntimeException(
                        "Unknown mode"
                );
        }
    }
    private RecommendationResponse pendingRecommendation;
    public void approve() {
        if(pendingRecommendation != null) {
            calendarService.moveEvent(pendingRecommendation.getEventToMove(), pendingRecommendation.getSuggestedTime());
        }
    }
}