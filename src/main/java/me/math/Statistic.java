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
        double m = mean(vector);
        double d = dispersion(vector, m);


        return Vector.applyToVector(vector, v-> ((v - m) / d));
    }

    private Statistic() {
    }
}


