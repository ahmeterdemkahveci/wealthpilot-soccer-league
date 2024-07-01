package com.wealthpilot.domain.strategy;

import com.wealthpilot.domain.factory.MatchScheduleFactory;
import com.wealthpilot.domain.model.Match;
import com.wealthpilot.domain.model.Team;

import java.time.LocalDate;
import java.util.List;

public class DefaultScheduleStrategy implements ScheduleStrategy {

    private final int matchesPerSaturday;

    public DefaultScheduleStrategy(int matchesPerSaturday) {
        this.matchesPerSaturday = matchesPerSaturday;
    }

    @Override
    public List<Match> generate(List<Team> teams, LocalDate startDate, String matchTime) {
        return MatchScheduleFactory.createSchedule(teams, startDate, matchTime, matchesPerSaturday);
    }
}