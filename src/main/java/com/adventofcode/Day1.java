package com.adventofcode;

import com.adventofcode.utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.adventofcode.utils.Util.wordToNumber;

public class Day1 {
    final static String testFile1 = "day1/test1.txt";
    final static String testFile2 = "day1/test2.txt";
    final static String inputFile = "day1/input.txt";

    public static void main(String[] args){
        Day1 solution = new Day1();

        var part1 = solution.runPart1(inputFile);
        var part2 = solution.runPart2(inputFile);

        System.out.println("Day 1");
        System.out.println("Part 1: The result is " + part1);
        System.out.println("Part 2: The result is " + part2);
    }

    int runPart(Pattern pattern, BiFunction<String, Pattern, Integer> calcCalibrationValue, String inputFile) {
        var sumOfCalibration = 0;
        List<String> lines = Util.readLines(inputFile);
        for (String line : lines) {
            sumOfCalibration += calcCalibrationValue.apply(line, pattern);
        }

        return sumOfCalibration;
    }

    int runPart1(String input){
        Pattern pattern = Pattern.compile("\\d");
        return runPart(pattern, Day1::calibrationValuePart1, input);
    }

    int runPart2(String input){
        Pattern pattern = Pattern.compile("(?=(one|two|three|four|five|six|seven|eight|nine|\\d))");
        return runPart(pattern, Day1::calibrationValuePart2, input);
    }

    private static int calibrationValuePart1(String line, Pattern numPattern) {
        List<String> numbers = new ArrayList<>(Arrays.asList("0", "0"));
        var firstNumber = true;

        Matcher matcher = numPattern.matcher(line);

        while (matcher.find()) {
            String match = matcher.group();
            if (firstNumber) {
                numbers.set(0, match);
                firstNumber = false;
            }
            numbers.set(1, match);
        }

        // Concatenate the two numbers and cast it to int
        return Integer.parseInt(numbers.get(0) + numbers.get(1));
    }

    private static int calibrationValuePart2(String line, Pattern numPattern) {
        List<String> numbers = new ArrayList<>(Arrays.asList("0", "0"));
        var firstNumber = true;

        Matcher matcher = numPattern.matcher(line);

        while (matcher.find()) {
            String match = matcher.group(1); // Capture the group within the lookahead
            if (firstNumber) {
                numbers.set(0, match);
                firstNumber = false;
            }
            numbers.set(1, match); // Always update the last number
        }

        // Concatenate the two numbers and cast it to int
        return Integer.parseInt("" + wordToNumber(numbers.get(0)) + wordToNumber(numbers.get(1)));
    }
}
