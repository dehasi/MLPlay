package me.math;

public final class MatrixMultiplication {
    // matrix-vector multiplication (y = A * x)
    public static double[] multiply(double[][] matrix, double[] x) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (x.length != n) throw new IllegalArgumentException("Illegal matrix dimensions.");
        double[] y = new double[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                y[i] += matrix[i][j] * x[j];
        return y;
    }

    // vector-matrix multiplication (y = x^T A)
    public static double[] multiply(double[] x, double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (x.length != m) throw new IllegalArgumentException("Illegal matrix dimensions.");
        double[] y = new double[n];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                y[j] += x[i] * matrix[i][j];
        return y;
    }

    // return C = A * B
    public static double[][] multiply(final double[][] A, final double[][] B) {
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) throw new IllegalArgumentException("Illegal matrix dimensions.");
        double[][] C = new double[mA][nB];
        for (int i = 0; i < mA; i++)
            for (int j = 0; j < nB; j++)
                for (int k = 0; k < nA; k++)
                    C[i][j] += A[i][k] * B[k][j];
        return C;
    }

    private MatrixMultiplication() {
    }
}
