package me.math;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static me.math.Statistic.mean;

/**
 * Tests for {@link Statistic}
 */
public class StatisticTest {

    @Test
    public void mean_returnsCorrectMean() {
        double[] x = {-2, -1, 0, 1, 2};

        double m = mean(x);

        assertEquals(0, m, 0.1);
    }


}
