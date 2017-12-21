package me.nn.perceptron

import spock.lang.Specification

/** Test for {@link PerceptronLearning} */
class PerceptronLearningTest extends Specification {
    PerceptronLearning learning = new PerceptronLearning()
        double[][] examples = [[1, 1, 0.3],
                               [1, 0.4, 0.5],
                               [1, 0.7, 0.8]]
        int[] responses = [1, 1, 0]

    def "should return zero correct weights"() {
        given:
        double[][] examples = [[], []]
        int[] responses = [0, 0]

        expect:
        learning.learn(examples, responses) == [0, 0] as double[]
    }

    def "should find correct weights"() {
        when:
        def weights = learning.learn(examples, responses)

        then:
        weights == [1.0, 1.6, -3.1000000000000005] as double[]
    }

    def "throw exception if it is not possible to find solution"() {
        when:
        learning.learn(examples, responses, 1) == [0, 0] as double[]

        then:
        IllegalStateException ex = thrown()
    }
}
