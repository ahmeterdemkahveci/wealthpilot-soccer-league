Wealthpilot Soccer League Scheduler

This project is a Java Spring Boot application designed to generate a soccer league schedule. The application reads teams from a JSON file and outputs a game plan, ensuring matches are played every Saturday at a specific time. The schedule includes both first-leg and second-leg matches with a three-week break in between.

Features

Generates a soccer league schedule with matches every Saturday.
Supports custom configurations for start date, match time, and the number of matches per Saturday.
Implements Domain-Driven Design (DDD) principles.
Uses Swagger for API documentation.

Architecture

The application follows DDD principles, organized into distinct layers:

Domain Layer:
Model: Contains domain models such as Team and Match.
Factory: Responsible for creating schedules.
Builder: Constructs the match schedule.
Command: Executes the schedule generation.
Strategy: Defines the scheduling strategy.

Application Layer:
ScheduleService: Handles the scheduling logic and interacts with the domain layer.

Infrastructure Layer:
Configuration: Manages application configurations.
Persistence: Handles data persistence (e.g., loading teams from JSON files).
Scheduler: Manages scheduled tasks.
SwaggerConfig: Configures Swagger for API documentation.

Presentation Layer:
ScheduleController: Exposes the scheduling API.

Installation

Prerequisites

Java 17 or higher
Gradle
Spring Boot 3.x

Steps

1. Clone the repository:

git clone https://github.com/your-username/wealthpilot-soccer-league.git
cd wealthpilot-soccer-league

2. Build the project using Gradle:

./gradlew build

3. Run the application:

./gradlew bootRun

Configuration

Configure the application by modifying the application.properties file located in src/main/resources.

Example configuration:

schedule.startDate=2022-10-01
schedule.matchTime=17:00
schedule.matchesPerSaturday=3
schedule.jsonFile=src/main/resources/soccer_teams.json

Usage

API Endpoints

The application exposes the following endpoints:

Generate Schedule:
POST /schedule
Body: JSON array of teams
Response: JSON array of matches

Swagger UI

Access the Swagger UI for API documentation at:

http://localhost:8080/swagger-ui.html

Testing

Run Unit Tests

To run the unit tests, use the following command:

./gradlew test

Test Scenarios

14 Teams and 3 Matches per Saturday
10 Teams and 3 Matches per Saturday
20 Teams and 4 Matches per Saturday
Odd Number of Teams
Single Team

Example Test Class

package com.wealthpilot.domain.factory;

import com.wealthpilot.domain.model.Match;
import com.wealthpilot.domain.model.Team;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MatchScheduleFactoryTest {
    // Test cases here
}

License

This project is licensed under the MIT License.
