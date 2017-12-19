package me.nn.perceptron

import spock.lang.Specification

class PerceptronTest extends Specification {
    def "check activation function"() {
        given:
        double[] w = [-5, -1, 5, 0]
        double[] x = [1, 0, 1, 1]
        Perceptron p = new Perceptron(w)

        expect:
        p.activate(x) == 0
    }
}
