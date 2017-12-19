package me.math

import spock.lang.Specification

class MatrixInvertTest extends Specification {
    def matrix1d = [[1]] as double[][]
    def matrix2d = [[1, 2],
                    [3, 4]] as double[][]
    def matrix3d = [[7, -3, -3],
                    [-1, 1, 0],
                    [-1, 0, 1]] as double[][]

    def matrixNonInvertable = [[1, -1],
                               [2, -2]] as double[][]

    def "invert one dimensional"() {
        expect:
        Matrix.invert(matrix1d) == matrix1d
    }

    def "invert two dimensional"() {
        expect:
        Matrix.invert(matrix2d) == [[-2.0, 1.0],
                                    [1.5, -0.5]] as double[][]
    }

    def "invert three dimensional"() {
        expect:
        Matrix.invert(matrix3d) == [[1, 3, 3],
                                    [1, 4, 3],
                                    [1, 3, 4]] as double[][]
    }

    def "non invertable" () {
        expect:
        Matrix.invert(matrixNonInvertable)

    }
}
