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
        var part1 = solution.runPart1();

        System.out.println("Day 2");
        // System.out.println("Part 1: The result is " + part1);
        // System.out.println("Part 2: The result is " + part2);
    }

    int runPart1() {
        List<String> lines = Util.readLines(testFile1);
        Pattern gamePattern = Pattern.compile(".*:\\s");
        List<Game> games = new ArrayList<>();
        var i = 1;
        for (String line : lines) {
            Matcher matcher = gamePattern.matcher(line);

          if (matcher.find()) {
              String rollsString = matcher.replaceFirst("");
              System.out.println(rollsString);
          }

            Game game = new Game(i);
            games.add(game);
            i++;

            var rolls = game.getRolls();
            rolls.add(new Roll(2, 3, 5));
            rolls.add(new Roll(2, 3, 5));
        }
        for (Game game : games){
            // System.out.println(game);
        }
        return 0;
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
    int blueCubes;
    int greenCubes;

    public Roll(int redCubes, int blueCubes, int greenCubes) {
        this.redCubes = redCubes;
        this.blueCubes = blueCubes;
        this.greenCubes = greenCubes;
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
