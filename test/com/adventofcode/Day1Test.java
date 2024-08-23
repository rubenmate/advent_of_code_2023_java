package com.adventofcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {
    Day1 day1;

    @BeforeEach
    public void setUp()  {
        day1 = new Day1();
    }
    @Test
    public void testPart1() {
        assertEquals(142, day1.runPart1(Day1.testFile1));
    }
    @Test
    public void testPart2() {
        assertEquals(281, day1.runPart2(Day1.testFile2));
    }
}
