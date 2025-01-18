package com.colors;

import java.util.Set;

public class Data {
    private int max;
    private Set<Pair> pairs;


    public Data(int max, Set<Pair> pairs) {
        this.max = max;
        this.pairs = pairs;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Set<Pair> getPairs() {
        return pairs;
    }

    public void setPairs(Set<Pair> pairs) {
        this.pairs = pairs;
    }
}

