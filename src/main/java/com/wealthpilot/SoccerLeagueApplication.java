package com.wealthpilot;

import com.wealthpilot.infrastructure.configuration.ScheduleProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SoccerLeagueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoccerLeagueApplication.class, args);
    }

}
