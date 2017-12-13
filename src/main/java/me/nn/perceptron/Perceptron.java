package me.nn.perceptron;

import com.google.common.base.Preconditions;

import java.util.Arrays;

/**
 * Simple representation of perceptron.
 */
public class Perceptron {
    private double[] weights;

    public Perceptron(double[] weights) {
        Preconditions.checkNotNull(weights);
        this.weights = Arrays.copyOf(weights, weights.length);
    }

    public double[] getWeights() {
        return Arrays.copyOf(weights, weights.length);
    }

    public double getBias() {
        return weights[0];
    }

    public int activate(double[] x) {
        Preconditions.checkNotNull(x);
        Preconditions.checkState(weights.length == x.length, "weight and input lengths should be equal.");
        return scalar(weights, x) > 0 ? 1 : 0;
    }

    private double scalar(double[] v1, double[] v2) {
        double result = 0.;
        for (int i = 0; i < v1.length; i++) {
            result += v1[i] * v2[i];
        }
        return result;
    }
}
