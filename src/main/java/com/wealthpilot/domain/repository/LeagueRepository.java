package com.wealthpilot.domain.repository;

import com.wealthpilot.domain.model.League;
import java.io.IOException;

public interface LeagueRepository {
    League loadLeague() throws IOException;
}