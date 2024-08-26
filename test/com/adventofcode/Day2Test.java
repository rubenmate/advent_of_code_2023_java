package com.adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
    Day2 day2;
    List<Game> games;

    @BeforeEach
    void setUp() {
        day2 = new Day2();
        games = Day2.initializeGames(Day2.testFile1);
    }

    @Nested
    class testParsing {
        @Test
        void testParsedGames() {
            assertEquals(5, games.size());
        }

        @Test
        void testParsedRolls() {
            // Retrieve the rolls from the first game
            List<Roll> rollsGame1 = games.getFirst().getRolls();

            // Define the expected values for each roll
            int[] expectedRed = {4, 1, 0};   // Expected red values for each roll
            int[] expectedGreen = {0, 2, 2}; // Expected green values for each roll
            int[] expectedBlue = {3, 6, 0};  // Expected blue values for each roll

            // Assert that the number of rolls matches the expected number
            assertEquals(expectedRed.length, rollsGame1.size(), "Number of rolls should match");

            // Compare the expected and actual values for each roll
            for (int i = 0; i < rollsGame1.size(); i++) {
                Roll roll = rollsGame1.get(i);
                assertEquals(expectedRed[i], roll.getRedCubes(), "Red cubes in roll " + (i + 1) + " should match");
                assertEquals(expectedGreen[i], roll.getGreenCubes(), "Green cubes in roll " + (i + 1) + " should match");
                assertEquals(expectedBlue[i], roll.getBlueCubes(), "Blue cubes in roll " + (i + 1) + " should match");
            }
        }
    }

    @Test
    void testRunPart1() {
        assertEquals(8, day2.runPart1(games));
    }

    @Test
    void testRunPart2() {
        assertEquals(2286, day2.runPart2(games));
    }
}
