package me.math

import spock.lang.Specification

class MatrixMultiplicationTest extends Specification {
    def matrix3d = [[1, 2, 3],
                    [4, 5, 6],
                    [7, 8, 9]] as double[][]

    def "multiply matrix to matrix square"() {
        expect:
        MatrixMultiplication.multiply(matrix3d, matrix3d) == [[30, 36, 42],
                                                              [66, 81, 96],
                                                              [102, 126, 150]] as double[][]
    }

    //TODO: write tests
    def "multiply matrix to matrix rectangle"() {}

    def "multiply matrix with illegal dimensions"() {}

    def "multiply matrix to vector"() {
        def vector = [1, 2, 3] as double[]

        expect:
        MatrixMultiplication.multiply(vector, matrix3d) == [30, 36, 42] as double[]
    }

    def "multiply vector to matrix"() {
        def vector = [1, 2, 3] as double[]

        expect:
        MatrixMultiplication.multiply(matrix3d, vector) == [14, 32, 50] as double[]
    }

}
