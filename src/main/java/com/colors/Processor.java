package com.colors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Processor {

    public static void process(Data data) {

        // On récupère les paires
        Set<Pair> pairs = data.getPairs();

        // List to store groups of pairs
        List<List<Pair>> groups = new ArrayList<>();

        // On trie nos paires par groupes
        while (!pairs.isEmpty()) {

            // Step 1: Calculate the frequency of each color
            Map<String, Integer> colorFrequency = calculateColorFrequency(pairs);

            // Step 2: Find the color with the highest frequency
            String mostFrequentColor = findMostFrequentColor(colorFrequency);

            // Step 3: Create a new group to store the pairs
            List<Pair> group = new ArrayList<>();

            // Step 4: Add pairs that contain the most frequent color to the group
            Iterator<Pair> iterator = pairs.iterator();
            while (iterator.hasNext() && group.size() < data.getMax()) {
                Pair pair = iterator.next();
                if (pair.containsColor(mostFrequentColor)) {
                    group.add(pair);
                    iterator.remove();  // Remove the pair from the original set
                }
            }

            // Add the formed group to the groups list
            groups.add(group);
        }

        // Print the formed groups
        System.out.println("Groups formed: ");
        for (List<Pair> group : groups) {
            System.out.println(group);
        }
    }

    // Calculate the frequency of each color in the remaining pairs
    private static Map<String, Integer> calculateColorFrequency(Set<Pair> pairs) {
        Map<String, Integer> colorFrequency = new HashMap<>();
        for (Pair pair : pairs) {
            colorFrequency.put(pair.getColor1(), colorFrequency.getOrDefault(pair.getColor1(), 0) + 1);
            colorFrequency.put(pair.getColor2(), colorFrequency.getOrDefault(pair.getColor2(), 0) + 1);
        }
        return colorFrequency;
    }

    // Find the most frequent color in the given frequency map
    private static String findMostFrequentColor(Map<String, Integer> colorFrequency) {
        return colorFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
