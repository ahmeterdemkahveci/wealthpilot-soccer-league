package com.wealthpilot.domain.builder;

import com.wealthpilot.domain.model.Match;
import com.wealthpilot.domain.model.Team;
import com.wealthpilot.domain.strategy.ScheduleStrategy;

import java.time.LocalDate;
import java.util.List;

public class MatchScheduleBuilder {
    private List<Team> teams;
    private LocalDate startDate;
    private String matchTime;
    private ScheduleStrategy strategy;

    public MatchScheduleBuilder setTeams(List<Team> teams) {
        this.teams = teams;
        return this;
    }

    public MatchScheduleBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public MatchScheduleBuilder setMatchTime(String matchTime) {
        this.matchTime = matchTime;
        return this;
    }

    public MatchScheduleBuilder setStrategy(ScheduleStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public List<Match> build() {
        return strategy.generate(teams, startDate, matchTime);
    }
}