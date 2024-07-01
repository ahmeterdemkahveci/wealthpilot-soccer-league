package com.wealthpilot.domain.model;

public class Team {
    private String name;
    private String foundingDate;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, String foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public String getName() {
        return name;
    }

    public String getFoundingDate() {
        return foundingDate;
    }
}