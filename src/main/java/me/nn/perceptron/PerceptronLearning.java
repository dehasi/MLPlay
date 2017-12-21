package me.nn.perceptron;

import com.google.common.base.Preconditions;
import me.math.Vector;

/**
 * Perceptron learning algorithm.
 */
public class PerceptronLearning {
    public double[] learn(double[][] examples, double[] responses) {
        Preconditions.checkState(examples.length == responses.length, "Amount of examples and answers should be equal");
        double[] w = new double[examples.length];
        boolean perfect = false;
        int watchDog = 1000;
        while (!perfect) {
            if (watchDog < 0 ) {
                break;
            }
            --watchDog;

            perfect = true;
            for (double[] e : examples) {
                int predicted = predict(e);
                if (predicted != target(e)) {
                    perfect = false;
                    if (predicted == 0) {
                        w = Vector.applyVectors(w, e, (x1, x2) -> x1 + x2);
                    } else {
                        w = Vector.applyVectors(w, e, (x1, x2) -> x1 - x2);
                    }
                }
            }
        }
        return w;
    }

    private int predict(double[] e) {
        return 0;
    }

    private int target(double[] e) {
        return 0;
    }
}
