package me.nn.perceptron;

import com.google.common.base.Preconditions;
import me.math.Vector;

/**
 * Perceptron learning algorithm.
 */
public class PerceptronLearning {
    public double[] learn(double[][] examples, int[] responses) {
        Preconditions.checkState(examples.length == responses.length, "Amount of examples and answers should be equal");
        double[] w = new double[examples.length];
        boolean perfect = false;
        int watchDog = 1000;
        while (!perfect) {
            if (watchDog < 0 ) {
                throw new IllegalStateException("It is not possible ot find solution");
            }
            --watchDog;

            perfect = true;
            for (int i = 0; i < examples.length; i++) {
                double[] e =  examples[i];
                int predicted = predict(e,w);
                if (predicted != responses[i]) {
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

    private int predict(double[] e, double[] w) {
        return Vector.multiplyScalar(e, w) > 0 ? 1 : 0;
    }
}
