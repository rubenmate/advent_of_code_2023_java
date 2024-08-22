package com.adventofcode.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public static List<String> readLines(String file){
        List<String> lines = new ArrayList<String>();
        try {
            ClassLoader classLoader = Util.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream(file);
            if (is == null) {
                throw new FileNotFoundException(file);
            } else {
                Reader ir = new InputStreamReader(is);
                BufferedReader in = new BufferedReader(ir);
                String line;
                while ((line = in.readLine()) != null)
                    lines.add(line);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return lines;
    }

    private static final Map<String, Integer> wordToNumberMap = new HashMap<>();
    static {
        wordToNumberMap.put("one", 1);
        wordToNumberMap.put("two", 2);
        wordToNumberMap.put("three", 3);
        wordToNumberMap.put("four", 4);
        wordToNumberMap.put("five", 5);
        wordToNumberMap.put("six", 6);
        wordToNumberMap.put("seven", 7);
        wordToNumberMap.put("eight", 8);
        wordToNumberMap.put("nine", 9);
    }

    public static int wordToNumber(String word) {
        Integer number;
        try {
            number = Integer.parseInt(word);
        } catch (NumberFormatException e) {
            number = wordToNumberMap.getOrDefault(word.toLowerCase(), 0);
        }
        return number;
    }
}
