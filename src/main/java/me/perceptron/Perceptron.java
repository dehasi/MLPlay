package me.perceptron;

import com.google.common.base.Preconditions;

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
        return Arrays.copyOf(w, w.length);
    }

    public int activate(double[] x) {
        Preconditions.checkState(w.length == x.length, "weight and input lengths should be equal.");
        return scalar(w, x) > 0 ? 1 : 0;
    }

    private double scalar(double[] v1, double[] v2) {
        double result = 0.;
        for (int i = 0; i < v1.length; i++) {
            result += v1[i] * v2[i];
        }
        return result;
    }
}
