package com.wealthpilot.domain.model;

import java.time.LocalDate;

public class Match {
    private LocalDate date;
    private String team1;
    private String team2;
    private String time;

    public Match() {
    }

    public Match(LocalDate date, String team1, String team2, String time) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getTime() {
        return time;
    }
}