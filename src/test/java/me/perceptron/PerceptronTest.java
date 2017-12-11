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

    @Test
    public void activate_returnsZero() {
        double w[] = new double[]{-5, -1, 5, 0};
        double x[] = new double[]{1, 0, 1,1};
        Perceptron p = new Perceptron(w);

        Assert.assertEquals(p.activate(x), 0);
    }
}
