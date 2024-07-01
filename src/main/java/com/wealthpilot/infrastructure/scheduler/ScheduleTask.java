package com.wealthpilot.infrastructure.scheduler;

import com.wealthpilot.application.ScheduleService;
import com.wealthpilot.domain.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleTask {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleTask(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Scheduled(cron = "0 0 0 * * SUN") // Runs every Sunday at midnight
    public void generateWeeklySchedule() {
        List<Match> schedule = scheduleService.generateSchedule();
        // Implement logic to persist or process the generated schedule if needed
    }
}