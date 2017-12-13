package me.math;

/**
 * Some basic statistical computations.
 */
public final class Statistic {

    public static double mean(final double[] x) {
        double m = 0;
        double n = x.length;
        for (double aX : x) {
            m += aX;
        }

        return m / n;
    }

    public static double dispersion(final double[] x) {
        double m = mean(x);
        double n = x.length;
        double d = 0;
        return dispersion(x, m);
    }

    public static double dispersion(final double[] x, double mean) {
        double n = x.length;
        double d = 0;

        for (double aX : x) {
            d += (aX - mean) * (aX - mean);
        }
        d = d / (n - 1);
        return d;
    }

    public static double[] normalize(final double[] vector) {
        double[] x = new double[vector.length];
        double m = mean(vector);
        double d = dispersion(vector, m);

        for (int i = 0; i < x.length; i++) {
            x[i] = (vector[i] - m) / d;
        }
        return x;
    }

    private Statistic() {
    }
}


