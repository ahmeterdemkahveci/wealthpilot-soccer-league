package com.wealthpilot.infrastructure.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "schedule")
public class ScheduleProperties {
    private String startDate;
    private String matchTime;
    private int matchesPerSaturday;
    private String jsonFile;

    // Getters and Setters
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public int getMatchesPerSaturday() {
        return matchesPerSaturday;
    }

    public void setMatchesPerSaturday(int matchesPerSaturday) {
        this.matchesPerSaturday = matchesPerSaturday;
    }

    public String getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(String jsonFile) {
        this.jsonFile = jsonFile;
    }
}