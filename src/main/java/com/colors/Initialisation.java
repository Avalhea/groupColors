package com.colors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Initialisation {

    static Scanner scanner = new Scanner(System.in);

    public static Data initialize() {
        Set<Pair> pairs = initiatePairs();
        int max = initiateMax(pairs.size());
        return new Data(max, pairs);
    }

    public static int initiateMax(int nbPairs) {
        int max = 0;
        System.out.println("Enter the maximum amount of pairs per chunk desired :");

        while (true) {
            if (scanner.hasNextInt()) {
                max = scanner.nextInt();
                break;
            } else {
                System.out.println("That's not a valid number. Try again.");
                scanner.next();
            }
        }
        return max;
    }

    public static Set<Pair> initiatePairs() {
        List<String> colors = Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Orange", "Pink", "Brown", "Cyan", "Magenta", "Lime", "Teal", "Lavender", "Black", "White", "Gray", "Gold", "Silver", "Beige", "Maroon");
        Random random = new Random();
        int numberOfPairs = random.nextInt(300) + 1;  // Generate a random number of pairs (between 1 and 300)
        Set<Pair> pairs = new HashSet<>();

        while (pairs.size() < numberOfPairs) {
            String colorA = colors.get(random.nextInt(colors.size()));
            String colorB = colors.get(random.nextInt(colors.size()));

            if (!colorA.equals(colorB)) {
                Pair pair = new Pair(colorA, colorB);
                pairs.add(pair);
            }
        }

        // Print the generated pairs
        System.out.println("Generated pairs: " + pairs);
        return pairs;
    }
}
