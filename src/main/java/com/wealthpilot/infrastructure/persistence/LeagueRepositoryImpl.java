package com.wealthpilot.infrastructure.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wealthpilot.domain.model.League;
import com.wealthpilot.domain.repository.LeagueRepository;
import com.wealthpilot.infrastructure.configuration.ScheduleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class LeagueRepositoryImpl implements LeagueRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ScheduleProperties scheduleProperties;

    @Autowired
    public LeagueRepositoryImpl(ScheduleProperties scheduleProperties) {
        this.scheduleProperties = scheduleProperties;
    }

    @Override
    public League loadLeague() throws IOException {
        return objectMapper.readValue(new File("src/main/resources/" + scheduleProperties.getJsonFile()), League.class);
    }
}