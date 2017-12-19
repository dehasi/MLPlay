package me.math

import spock.lang.Specification

class MatrixMultiplicationTest extends Specification {
    def matrix3d = [[1, 2, 3],
                    [4, 5, 6],
                    [7, 8, 9]] as double[][]

    def matrix3x2 = [[1, 2],
                     [4, 5],
                     [7, 8]] as double[][]


    def matrix2x3 = [[1, 2, 3],
                     [4, 5, 6]] as double[][]


    def "multiply matrix to matrix square"() {
        expect:
        MatrixMultiplication.multiply(matrix3d, matrix3d) == [[30, 36, 42],
                                                              [66, 81, 96],
                                                              [102, 126, 150]] as double[][]
    }


    def "multiply matrix3x2 to 2x3"() {
        expect:
        MatrixMultiplication.multiply(matrix3x2, matrix2x3) == [[9, 12, 15],
                                                                [24, 33, 42],
                                                                [39, 54, 69]] as double[][]

    }

    def "multiply matrix 2x3 to 3x2ś"() {
        expect:
        MatrixMultiplication.multiply(matrix2x3, matrix3x2) == [[30, 36],
                                                                [66, 81]] as double[][]

    }

    def "multiply matrix with illegal dimensions"() {

        when:
        MatrixMultiplication.multiply(matrix3x2, matrix3x2)

        then:
        IllegalArgumentException ex = thrown()
    }

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
