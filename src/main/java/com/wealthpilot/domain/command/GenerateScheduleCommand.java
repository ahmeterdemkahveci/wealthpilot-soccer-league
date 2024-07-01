package com.wealthpilot.domain.command;

import com.wealthpilot.domain.builder.MatchScheduleBuilder;
import com.wealthpilot.domain.model.Match;

import java.util.List;

public class GenerateScheduleCommand {
    private final MatchScheduleBuilder builder;

    public GenerateScheduleCommand(MatchScheduleBuilder builder) {
        this.builder = builder;
    }

    public List<Match> execute() {
        return builder.build();
    }
}