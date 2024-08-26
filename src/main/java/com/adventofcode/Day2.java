package com.adventofcode;

import com.adventofcode.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {
    final static String testFile1 = "day2/test1.txt";
    final static String inputFile = "day2/input.txt";

    public static void main(String[] args){
        Day2 solution = new Day2();

        var games = initializeGames();

        var part1 = solution.runPart1(games);
        var part2 = solution.runPart2(games);

        System.out.println("Day 2");
        System.out.println("Part 1: The result is " + part1);
        System.out.println("Part 2: The result is " + part2);
    }

    int runPart1(List<Game> games) {
        var result = 0;
        for (Game game : games){
            if (game.isPossible()) {
                result += game.getId();
            }
        }
        return result;
    }

    int runPart2(List<Game> games) {
        var result = 0;
        for (Game game : games){
            var minimumRoll = game.minimumRoll();
            var powers = minimumRoll.redCubes * minimumRoll.greenCubes * minimumRoll.blueCubes;
            result += powers;
        }
        return result;
    }

    static List<Game> initializeGames() {

        List<String> lines = Util.readLines(inputFile);

        Pattern gamePattern = Pattern.compile(".*:\\s");
        Pattern rollsPattern = Pattern.compile("(\\d+)\\s(red|green|blue)");

        List<Game> games = new ArrayList<>();
        var i = 1;
        for (String line : lines) {
            Matcher matcher = gamePattern.matcher(line);

            if (matcher.find()) {
                Game game = new Game(i);
                i++;
                var rolls = game.getRolls();

                String rollsString = matcher.replaceFirst("");

                String[] rollsStringSplit = rollsString.split(";");

                for (String roll : rollsStringSplit) {
                    Matcher rollMatcher = rollsPattern.matcher(roll);
                    int red = 0, green = 0, blue = 0;
                    while (rollMatcher.find()) {
                        String color = rollMatcher.group(2);
                        String number = rollMatcher.group(1);
                        switch (color) {
                            case "red":
                                red += Integer.parseInt(number);
                                break;
                            case "green":
                                green += Integer.parseInt(number);
                                break;
                            case "blue":
                                blue += Integer.parseInt(number);
                                break;
                        }
                    }
                    rolls.add(new Roll(red, green, blue));
                }

                games.add(game);
            }
        }
        return games;
    }

}

class Game {
    private int id;
    private List<Roll> rolls;

    public Game(int id) {
        this.id = id;
        this.rolls = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    public boolean isPossible() {
        boolean isPossible = true;
        var rolls = this.rolls;
        for (Roll roll : rolls) {
            if (roll.redCubes > 12) { isPossible = false; break; }
            else if (roll.greenCubes > 13) { isPossible = false; break; }
            else if (roll.blueCubes > 14) { isPossible = false; break; }
        }
        return isPossible;
    }

    public Roll minimumRoll() {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;

        for (Roll roll : this.rolls) {
            maxRed = Math.max(maxRed, roll.redCubes);
            maxGreen = Math.max(maxGreen, roll.greenCubes);
            maxBlue = Math.max(maxBlue, roll.blueCubes);
        }

        return new Roll(maxRed, maxGreen, maxBlue);
    }

    @Override
    public String toString() {
        StringBuilder rollString = new StringBuilder();
        for (Roll roll : rolls) {
            rollString.append(roll.toString());
            rollString.append(" ");
        }
        return "[Game] id: " + id + " rolls: " + rollString;
    }
}

class Roll {
    int redCubes;
    int greenCubes;
    int blueCubes;

    public Roll(int redCubes, int greenCubes, int blueCubes) {
        this.redCubes = redCubes;
        this.greenCubes = greenCubes;
        this.blueCubes = blueCubes;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "redCubes=" + redCubes +
                ", blueCubes=" + blueCubes +
                ", greenCubes=" + greenCubes +
                '}';
    }
}
