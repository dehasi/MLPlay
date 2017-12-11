package me.perceptron;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for @{@link Perceptron}
 */
public class PerceptronTest {
    @Test
    public void getW_returnsValidWeights() {
        double w[] = new double[]{1,2,3};
        Perceptron p = new Perceptron(w);
        Assert.assertArrayEquals(p.getW(), w, 0.01);
    }
}
