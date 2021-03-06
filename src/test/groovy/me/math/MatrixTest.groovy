package me.math

import spock.lang.Specification

class MatrixTest extends Specification {
    def matrix = [[1, 2, 3],
                  [4, 5, 6],
                  [7, 8, 9]] as double[][]

    def "transpose"() {
        expect:
        Matrix.transpose(matrix) == transposedMatrix

        where:
        transposedMatrix = [[1, 4, 7],
                            [2, 5, 8],
                            [3, 6, 9]] as double[][]
    }

    def "transpose one-dimensional matrix"() {
        given:
        def matrix = [[1]] as double[][]

        expect:
        Matrix.transpose(matrix) == matrix
    }

    def "extract row"() {
        expect:
        Matrix.extractRow(matrix, rowNum) == row

        where:
        rowNum || row
        0      || [1, 2, 3] as double[]
        1      || [4, 5, 6] as double[]
        2      || [7, 8, 9] as double[]
    }

    def "extract column"() {
        expect:
        Matrix.extractColumn(matrix, colNum) == column

        where:
        colNum || column
        0      || [1, 4, 7] as double[]
        1      || [2, 5, 8] as double[]
        2      || [3, 6, 9] as double[]
    }

    def "eye one-dimensional matrix"() {
        expect:
        Matrix.eye(1) == [[1]] as double[][]
    }

    def "eye"() {
        expect:
        Matrix.eye(2) == [[1, 0], [0, 1]] as double[][]
    }

    def "concat one-dimensional matrix"() {
        def one = [[1]] as double[][]
        expect:
        Matrix.concat(one, one) == [[1, 1]] as double[][]
    }
    def "concat"() {
        expect:
        Matrix.concat(matrix, matrix) == [[1, 2, 3, 1, 2, 3],
                                          [4, 5, 6, 4, 5, 6],
                                          [7, 8, 9, 7, 8, 9]] as double[][]
    }
}
