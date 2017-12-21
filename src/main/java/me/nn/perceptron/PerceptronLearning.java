package me.nn.perceptron;

import com.google.common.base.Preconditions;
import me.math.Vector;

/**
 * Perceptron learning algorithm.
 */
public class PerceptronLearning {
    public double[] learn(double[][] examples, int[] responses) {
        return learn(examples, responses, 1000);
    }

    public double[] learn(double[][] examples, int[] responses, long iterations){
        Preconditions.checkState(examples.length == responses.length, "Amount of examples and answers should be equal");
        Preconditions.checkState(iterations > 0, "The number of iterations must be positive");

        double[] weights = new double[examples.length];
        boolean perfect = false;

        while (!perfect) {
            if (iterations < 0 ) {
                throw new IllegalStateException("It is not possible ot find solution");
            }
            --iterations;

            perfect = true;
            for (int i = 0; i < examples.length; i++) {
                double[] e =  examples[i];
                int predicted = predict(e,weights);
                if (predicted != responses[i]) {
                    perfect = false;
                    if (predicted == 0) {
                        weights = Vector.applyVectors(weights, e, (x1, x2) -> x1 + x2);
                    } else {
                        weights = Vector.applyVectors(weights, e, (x1, x2) -> x1 - x2);
                    }
                }
            }
        }
        return weights;
    }

    private int predict(double[] e, double[] w) {
        return Vector.multiplyScalar(e, w) > 0 ? 1 : 0;
    }
}
