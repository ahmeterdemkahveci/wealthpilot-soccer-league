package com.wealthpilot.application;

import com.wealthpilot.domain.builder.MatchScheduleBuilder;
import com.wealthpilot.domain.command.GenerateScheduleCommand;
import com.wealthpilot.domain.model.Match;
import com.wealthpilot.domain.repository.LeagueRepository;
import com.wealthpilot.domain.strategy.DefaultScheduleStrategy;
import com.wealthpilot.infrastructure.configuration.ScheduleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService {

    private final LeagueRepository leagueRepository;
    private final ScheduleProperties scheduleProperties;

    @Autowired
    public ScheduleService(LeagueRepository leagueRepository, ScheduleProperties scheduleProperties) {
        this.leagueRepository = leagueRepository;
        this.scheduleProperties = scheduleProperties;
    }

    public List<Match> generateSchedule() {
        try {
            var league = leagueRepository.loadLeague();
            var teams = league.getTeams();

            if (teams.size() < scheduleProperties.getMatchesPerSaturday() * 2) {
                throw new IllegalArgumentException("Number of matches per Saturday exceeds half the number of teams.");
            }

            var builder = new MatchScheduleBuilder()
                    .setTeams(teams)
                    .setStartDate(LocalDate.parse(scheduleProperties.getStartDate()))
                    .setMatchTime(scheduleProperties.getMatchTime())
                    .setStrategy(new DefaultScheduleStrategy(scheduleProperties.getMatchesPerSaturday()));

            var command = new GenerateScheduleCommand(builder);

            return command.execute();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load league data", e);
        }
    }
}