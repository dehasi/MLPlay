package me.math

import spock.lang.Specification

import java.util.function.BiFunction
import java.util.function.Function

class VectorTest extends Specification {
    def "scalar multiplication"() {
        given:
        double[] x1 = [1, 2, 3, 4]
        double[] x2 = [4, 3, 2, 1]

        expect:
        Vector.multiplyScalar(x1, x2) == 20
    }

    def "logarithm is applied"() {
        given:
        double[] x = [Math.E, Math.E * Math.E, Math.E * Math.E * Math.E, Math.E * Math.E * Math.E * Math.E]

        expect:
        Vector.logarithm(x) == [1, 2, 3, 4] as double[]
    }

    def "applyToVector applies a function"() {
        given:
        double[] x = [1, 2, 3, 4]
        Function<Double, Double> function = new Function<Double, Double>() {
            @Override
            Double apply(Double aDouble) {
                return aDouble * aDouble;
            }
        }
        expect:
        Vector.applyToVector(x, function) == [1, 4, 9, 16] as double[]
    }

    def "applyVectors returns sum of vectors"() {
        given:
        double[] v1 = [1, 2, 3, 4]
        double[] v2 = [4, 3, 2, 1]
        BiFunction<Double, Double, Double> function = new BiFunction<Double, Double, Double>() {
            @Override
            Double apply(Double x1, Double x2) {
                return x1 + x2;
            }
        }
        expect:
        Vector.applyVectors(v1, v2, function) == [5, 5, 5, 5] as double[]
    }
}
