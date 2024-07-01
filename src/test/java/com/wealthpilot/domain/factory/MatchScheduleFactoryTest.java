package com.wealthpilot.domain.factory;

import com.wealthpilot.domain.model.Match;
import com.wealthpilot.domain.model.Team;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MatchScheduleFactoryTest {

    @Test
    public void testGenerateScheduleWith14TeamsAnd3MatchesPerSaturday() {
        List<Team> teams = Arrays.asList(
                new Team("Team1"), new Team("Team2"), new Team("Team3"),
                new Team("Team4"), new Team("Team5"), new Team("Team6"),
                new Team("Team7"), new Team("Team8"), new Team("Team9"),
                new Team("Team10"), new Team("Team11"), new Team("Team12"),
                new Team("Team13"), new Team("Team14")
        );

        LocalDate startDate = LocalDate.of(2022, 10, 1);
        String matchTime = "17:00";
        int matchesPerSaturday = 3;

        List<Match> schedule = MatchScheduleFactory.createSchedule(teams, startDate, matchTime, matchesPerSaturday);

        assertNotNull(schedule);
        assertEquals(14, schedule.size()); // 7 matches per leg, 2 legs
        assertEquals(startDate.plusWeeks(5), schedule.get(schedule.size() - 1).getDate()); // Ensure dates are correct

        // Ensure no team plays more than once per Saturday
        for (int i = 0; i < schedule.size(); i += matchesPerSaturday) {
            List<Match> weekMatches = schedule.subList(i, Math.min(i + matchesPerSaturday, schedule.size()));
            assertNoTeamPlaysMoreThanOnce(weekMatches);
        }
    }

    @Test
    public void testGenerateScheduleWith10TeamsAnd3MatchesPerSaturday() {
        List<Team> teams = Arrays.asList(
                new Team("Team1"), new Team("Team2"), new Team("Team3"),
                new Team("Team4"), new Team("Team5"), new Team("Team6"),
                new Team("Team7"), new Team("Team8"), new Team("Team9"),
                new Team("Team10")
        );

        LocalDate startDate = LocalDate.of(2022, 10, 1);
        String matchTime = "17:00";
        int matchesPerSaturday = 3;

        List<Match> schedule = MatchScheduleFactory.createSchedule(teams, startDate, matchTime, matchesPerSaturday);

        assertNotNull(schedule);
        assertEquals(10, schedule.size()); // 5 matches per leg, 2 legs
        assertEquals(startDate.plusWeeks(4), schedule.get(schedule.size() - 1).getDate()); // Ensure dates are correct

        // Ensure no team plays more than once per Saturday
        for (int i = 0; i < schedule.size(); i += matchesPerSaturday) {
            List<Match> weekMatches = schedule.subList(i, Math.min(i + matchesPerSaturday, schedule.size()));
            assertNoTeamPlaysMoreThanOnce(weekMatches);
        }
    }

    @Test
    public void testGenerateScheduleWith20TeamsAnd4MatchesPerSaturday() {
        List<Team> teams = Arrays.asList(
                new Team("Team1"), new Team("Team2"), new Team("Team3"),
                new Team("Team4"), new Team("Team5"), new Team("Team6"),
                new Team("Team7"), new Team("Team8"), new Team("Team9"),
                new Team("Team10"), new Team("Team11"), new Team("Team12"),
                new Team("Team13"), new Team("Team14"), new Team("Team15"),
                new Team("Team16"), new Team("Team17"), new Team("Team18"),
                new Team("Team19"), new Team("Team20")
        );

        LocalDate startDate = LocalDate.of(2022, 10, 1);
        String matchTime = "17:00";
        int matchesPerSaturday = 4;

        List<Match> schedule = MatchScheduleFactory.createSchedule(teams, startDate, matchTime, matchesPerSaturday);

        assertNotNull(schedule);
        assertEquals(20, schedule.size()); // 10 matches per leg, 2 legs
        assertEquals(startDate.plusWeeks(5), schedule.get(schedule.size() - 1).getDate()); // Ensure dates are correct

        // Ensure no team plays more than once per Saturday
        for (int i = 0; i < schedule.size(); i += matchesPerSaturday) {
            List<Match> weekMatches = schedule.subList(i, Math.min(i + matchesPerSaturday, schedule.size()));
            assertNoTeamPlaysMoreThanOnce(weekMatches);
        }
    }

    @Test
    public void testGenerateScheduleWithOddNumberOfTeams() {
        List<Team> teams = Arrays.asList(
                new Team("Team1"), new Team("Team2"), new Team("Team3"),
                new Team("Team4"), new Team("Team5"), new Team("Team6")
        );

        LocalDate startDate = LocalDate.of(2022, 10, 1);
        String matchTime = "17:00";
        int matchesPerSaturday = 2;

        List<Match> schedule = MatchScheduleFactory.createSchedule(teams, startDate, matchTime, matchesPerSaturday);

        assertNotNull(schedule);
        assertEquals(6, schedule.size()); // 3 matches per leg, 2 legs
        assertEquals(startDate.plusWeeks(4), schedule.get(schedule.size() - 1).getDate()); // Ensure dates are correct

        // Ensure no team plays more than once per Saturday
        for (int i = 0; i < schedule.size(); i += matchesPerSaturday) {
            List<Match> weekMatches = schedule.subList(i, Math.min(i + matchesPerSaturday, schedule.size()));
            assertNoTeamPlaysMoreThanOnce(weekMatches);
        }
    }

    @Test
    public void testGenerateScheduleWithSingleTeam() {
        List<Team> teams = List.of(new Team("Team1"));

        LocalDate startDate = LocalDate.of(2022, 10, 1);
        String matchTime = "17:00";
        int matchesPerSaturday = 1;

        List<Match> schedule = MatchScheduleFactory.createSchedule(teams, startDate, matchTime, matchesPerSaturday);

        assertNotNull(schedule);
        assertTrue(schedule.isEmpty(), "The schedule should be empty as there are not enough teams to form a match.");
    }

    private void assertNoTeamPlaysMoreThanOnce(List<Match> matches) {
        List<String> teams = new ArrayList<>();
        for (Match match : matches) {
            if (teams.contains(match.getTeam1()) || teams.contains(match.getTeam2())) {
                throw new AssertionError("A team is scheduled to play more than once on the same day.");
            }
            teams.add(match.getTeam1());
            teams.add(match.getTeam2());
        }
    }
}