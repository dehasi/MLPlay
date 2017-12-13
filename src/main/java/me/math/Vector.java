package me.math;

import java.util.function.Function;

/**
 * Class for operations with one-dimensional array.
 */
public final class Vector {
    public static double[] applyToVector(double[] vector, Function<Double, Double> function) {
        double[] x = new double[vector.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = function.apply(vector[i]);
            if (Double.isNaN(x[i])) {
                throw new RuntimeException("x[" + i + "] is NaN");
            }
        }
        return x;
    }

    public static double[] logarithm(double[] vector, int col) {
        return applyToVector(vector, Math::log);
    }

    public static double multiplyScalar(double[] vector1, double[] vector2) {
        double result = 0.;
        for (int i = 0; i < vector1.length; i++) {
            result += vector1[i] * vector2[i];
        }
        return result;
    }

    public static void printVector(final double[] v) {
        for (double aV : v) {
            System.out.printf("%.2f\t", aV);
        }
        System.out.println("");
    }
    private Vector() {
    }
}
