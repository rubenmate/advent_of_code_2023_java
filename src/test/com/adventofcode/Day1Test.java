package com.adventofcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {
    @Test
    public void testPart1() {
        Day1 day1 = new Day1();
        assertEquals(142, day1.runPart1(Day1.testFile1));
    }
    @Test
    public void testPart2() {
        Day1 day1 = new Day1();
        assertEquals(281, day1.runPart2(Day1.testFile2));
    }
}
