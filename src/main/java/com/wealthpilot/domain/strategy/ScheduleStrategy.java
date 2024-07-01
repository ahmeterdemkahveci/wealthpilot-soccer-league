package com.wealthpilot.domain.strategy;

import com.wealthpilot.domain.model.Match;
import com.wealthpilot.domain.model.Team;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleStrategy {
    List<Match> generate(List<Team> teams, LocalDate startDate, String matchTime);
}