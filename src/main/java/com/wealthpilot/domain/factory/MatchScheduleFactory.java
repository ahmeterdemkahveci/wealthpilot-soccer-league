package com.wealthpilot.domain.factory;

import com.wealthpilot.domain.model.Match;
import com.wealthpilot.domain.model.Team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchScheduleFactory {

    public static List<Match> createSchedule(List<Team> teams, LocalDate startDate, String matchTime, int matchesPerSaturday) {
        List<Match> schedule = new ArrayList<>();
        List<Match> firstLeg = generateFirstLegSchedule(teams);
        LocalDate currentDate = startDate;

        // Assign dates to first leg matches
        schedule.addAll(assignDatesToMatches(firstLeg, currentDate, matchTime, matchesPerSaturday));

        // Break of 3 weeks
        currentDate = currentDate.plusWeeks(3);

        // Generate second leg schedule
        List<Match> secondLeg = generateSecondLegSchedule(firstLeg);

        // Assign dates to second leg matches
        schedule.addAll(assignDatesToMatches(secondLeg, currentDate, matchTime, matchesPerSaturday));

        return schedule;
    }

    private static List<Match> generateFirstLegSchedule(List<Team> teams) {
        List<Match> matches = new ArrayList<>();
        List<Team> remainingTeams = new ArrayList<>(teams);
        Collections.shuffle(remainingTeams); // Shuffle teams for random matchups

        // Generate random matches
        while (remainingTeams.size() > 1) {
            Team team1 = remainingTeams.remove(0);
            Team team2 = remainingTeams.remove(0);
            matches.add(new Match(null, team1.getName(), team2.getName(), null));
        }

        return matches;
    }

    private static List<Match> generateSecondLegSchedule(List<Match> firstLeg) {
        List<Match> secondLeg = new ArrayList<>();

        for (Match match : firstLeg) {
            secondLeg.add(new Match(null, match.getTeam2(), match.getTeam1(), null)); // Reverse home and away
        }

        return secondLeg;
    }

    private static List<Match> assignDatesToMatches(List<Match> matches, LocalDate startDate, String matchTime, int matchesPerSaturday) {
        List<Match> scheduledMatches = new ArrayList<>();
        LocalDate currentDate = startDate;

        for (int i = 0; i < matches.size(); i += matchesPerSaturday) {
            for (int j = 0; j < matchesPerSaturday && i + j < matches.size(); j++) {
                Match match = matches.get(i + j);
                scheduledMatches.add(new Match(currentDate, match.getTeam1(), match.getTeam2(), matchTime));
            }
            currentDate = currentDate.plusWeeks(1);
        }

        return scheduledMatches;
    }
}