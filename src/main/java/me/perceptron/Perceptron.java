package me.perceptron;

import java.util.Arrays;

/**
 * Simple representation of perceptron.
 */
public class Perceptron {
    private double[] w;

    public Perceptron(double[] w) {
        this.w = Arrays.copyOf(w, w.length);
    }

    public double[] getW() {
        return  Arrays.copyOf(w, w.length);
    }
}
