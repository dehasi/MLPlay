package me.math;

import com.google.common.base.Preconditions;

import java.util.function.BiFunction;
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

    public static double[] logarithm(double[] vector) {
        return applyToVector(vector, Math::log);
    }

    public static double multiplyScalar(double[] vector1, double[] vector2) {
        double result = 0.;
        for (int i = 0; i < vector1.length; i++) {
            result += vector1[i] * vector2[i];
        }
        return result;
    }

    public static double[] applyVectors(double[] x1, double[] x2, BiFunction<Double, Double, Double> function) {
        Preconditions.checkState(x1.length == x2.length, "Vectors length must be equal");
        int n = x1.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = function.apply(x1[i], x2[i]);
        }
        return result;
    }

    private Vector() {
    }
}
