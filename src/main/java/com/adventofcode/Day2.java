package com.adventofcode;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    final static String testFile1 = "day2/test1.txt";
    final static String inputFile = "day2/input.txt";

    public static void main(String[] args){
        Day2 solution = new Day2();

        System.out.println("Day 2");
        // System.out.println("Part 1: The result is " + part1);
        // System.out.println("Part 2: The result is " + part2);
        Game game = new Game(1);
        var rolls = game.getRolls();
        rolls.add(new Roll(2, 3, 5));
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
}
