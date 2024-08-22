package com.adventofcode;

import com.adventofcode.utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.adventofcode.utils.Util.wordToNumber;

public class Day1 {
    final static String testFile = "day1/test2.txt";
    final static String inputFile = "day1/input.txt";

    public static void main(String[] args){
        Day1 solution = new Day1();
        System.out.println("Day 1");
        solution.runPart1();
        solution.runPart2();
    }

    void runPart1(){
        var sumOfCalibration = 0;
        List<String> lines = Util.readLines(inputFile);
        for (String line : lines) {
            sumOfCalibration += calibrationValuePart1(line);
        }

        System.out.println("Part 1: The result is " + sumOfCalibration);
    }

    void runPart2(){
        var sumOfCalibration = 0;
        List<String> lines = Util.readLines(inputFile);
        for (String line : lines) {
            sumOfCalibration += calibrationValuePart2(line);
        }

        System.out.println("Part 2: The result is " + sumOfCalibration);
    }

    private static int calibrationValuePart1(String line) {
        var firstNumber = true;
        List<String> numbers = new ArrayList<>(Arrays.asList("0", "0"));
        // Apply regexp to line and extract the numbers
        Pattern numPattern = Pattern.compile("\\d");
        Matcher matcher = numPattern.matcher(line);
        while (matcher.find()) {
            if (firstNumber) {
                numbers.set(0, matcher.group());
                numbers.set(1, matcher.group());
                firstNumber = false;
            } else {
                // Overwrite the last number until we have the last occurrence
                numbers.set(1, matcher.group());
            }
        }
        // Concatenate the two numbers and cast it to int
        return Integer.parseInt(numbers.get(0) + numbers.get(1));
    }

    private static int calibrationValuePart2(String line) {
        var firstNumber = true;
        List<String> numbers = new ArrayList<>(Arrays.asList("0", "0"));
        // Apply regexp to line and extract the numbers
        Pattern numPattern = Pattern.compile("one|two|three|four|five|six|seven|eight|nine|\\d");
        Matcher matcher = numPattern.matcher(line);
        if (matcher.find()) {
            do {
                if (firstNumber) {
                    numbers.set(0, matcher.group());
                    numbers.set(1, matcher.group());
                    firstNumber = false;
                } else {
                    // Overwrite the last number until we have the last occurrence
                    numbers.set(1, matcher.group());
                }
            }
            while (matcher.find(matcher.start()+1));
        }

        // Concatenate the two numbers and cast it to int
        return Integer.parseInt("" + wordToNumber(numbers.get(0)) + wordToNumber(numbers.get(1)));
    }
}
