package me.math

import spock.lang.Specification

import static spock.util.matcher.HamcrestMatchers.closeTo
import static spock.util.matcher.HamcrestSupport.that

/** Tests for {@link Statistic} */
class StatisticTest extends Specification {
    private static final double MEAN = 4.5d
    private static final double DISPERSION = 9.16d
    private static final double ERROR = 0.01d
    private static final double[] vector = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]

    def "should count a correct mean"() {
        expect:
        Statistic.mean(vector) == MEAN
    }

    def "should count a correct dispersion"() {
        expect:
        that Statistic.dispersion(vector), closeTo(DISPERSION, ERROR)
    }

    def "should count a correct dispersion with mean"() {
        expect:
        that Statistic.dispersion(vector, MEAN), closeTo(DISPERSION, ERROR)
    }

    def "should normalize vector"() {
        double[] x = [1, 2, 0]
        expect:
        Statistic.normalize(x) == [0.0, 1.0, -1.0] as double[]
    }


}
