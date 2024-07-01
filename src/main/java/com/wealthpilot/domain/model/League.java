
package com.wealthpilot.domain.model;

import java.util.List;

public class League {
    private String league;
    private String country;
    private List<Team> teams;

    public League() {
    }

    public League(String league, List<Team> teams) {
        this.league = league;
        this.teams = teams;
    }

    public League(String league, String country, List<Team> teams) {
        this.league = league;
        this.country = country;
        this.teams = teams;
    }

    public String getLeague() {
        return league;
    }

    public String getCountry() {
        return country;
    }

    public List<Team> getTeams() {
        return teams;
    }
}