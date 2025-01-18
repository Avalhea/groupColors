package com.colors;

import java.util.Objects;

public class Pair {
    private String color1;
    private String color2;

    // Constructor to initialize colors
    public Pair(String color1, String color2) {

        // Sort the colors to ensure consistency in storage (smaller color comes first)
        if (color1.compareTo(color2) < 0) {
            this.color1 = color1;
            this.color2 = color2;
        } else {
            this.color1 = color2;
            this.color2 = color1;
        }
    }

    // Getter methods for color1 and color2
    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public boolean containsColor(String color) {
        return color1.equals(color) || color2.equals(color);
    }
    
    // Custom toString method to output the pair in the format (color1, color2)
    @Override
    public String toString() {
        return "(" + color1 + ", " + color2 + ")";
    }

    // Override equals to compare based on unordered colors
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair pair = (Pair) obj;
        return (color1.equals(pair.color1) && color2.equals(pair.color2));
    }

    // Override hashCode to ensure unordered equality
    @Override
    public int hashCode() {
        // Using a consistent way to calculate hash based on unordered colors
        return Objects.hash(color1, color2);
    }

}