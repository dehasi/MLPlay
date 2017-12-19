package me.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for matrix operations.
 */
public final class Matrix {

    // return C = A^T
    public static double[][] transpose(final double[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        double[][] temp = new double[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                temp[j][i] = matrix[i][j];
        return temp;
    }

    public static double[] extractColumn(final double[][] matrix, int col) {
        double[] x = new double[matrix.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = matrix[i][col];
        }
        return x;
    }

    public static double[] extractRow(final double[][] matrix, int row) {
        double[] x = new double[matrix[row].length];
        System.arraycopy(matrix[row], 0, x, 0, x.length);
        return x;
    }

    // return I matrix NxN
    public static double[][] eye(int n) {
        double x[][] = new double[n][n];
        for (int i = 0; i < n; i++) {
            x[i][i] = 1;
        }
        return x;
    }

    // concat 2 matrix
    public static double[][] concat(final double[][] A, final double[][] B) {
        int n = A[0].length + B[0].length;
        int m = A.length;

        assert A.length == B.length;

        double[][] x = new double[m][n];

        for (int i = 0; i < A.length; i++) {
            System.arraycopy(A[i], 0, x[i], 0, A[0].length);
        }

        for (int i = 0; i < A.length; i++) {
            System.arraycopy(B[i], A[0].length - A[0].length, x[i], A[0].length, A[0].length + B[0].length - A[0].length);
        }
        return x;
    }

    public static void printMatrix(final double[][] m) {

        int rows = m.length;
        int columns = m[0].length;
        for (double[] aM : m) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%.2f\t", aM[j]);
            }
            System.out.println("|");
        }

        System.out.println("");
        System.out.println("");

    }

    public static double[][] invert(final double[][] matrix) {
        double[][] result = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        int rows = result.length;
        int cols = result[0].length;
        double[][] identity = eye(rows);

        // make [A|E]
        result = concat(result, identity);

        int i = 0;
        for (int j = 0; j < cols; j++) {
            Pair p = createPair(result, i, j);
            int rs = p.first;
            int fnf = p.second;
            if (rs == 0) {
                //TODO: make only one return point
                return result;
            }
            if (fnf != i) {
                result = swapRow(result, i, fnf);
            }

            double[] scl = new double[result[i].length];
            for (int a = 0; a < result[i].length; a++) {
                scl[a] = result[i][a] / result[i][j];
            }
            for (int a = 0; a < result[i].length; a++) {
                result[i][a] = scl[a];
            }

            for (int k = 0; k < rows; k++) {
                if (k == i) {
                    continue;
                }

                scl = new double[result[i].length];
                for (int a = 0; a < result[i].length; a++) {
                    scl[a] = result[k][j] * result[i][a];
                }
                for (int l = 0; l < scl.length; l++) {
                    result[k][l] -= scl[l];
                }

            }
            if (i == rows) {
                break;
            }
            ++i;
        }

        // get A from  [E|A]
        int n = cols;
        double[][] y = new double[n][n];

        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                y[i][j] = result[i][j + n];
            }
        }
        return y;
    }

    private static double[][] swapRow(final double[][] m, int i, int first_non_falsy) {
        int n = m[i].length;

        for (int j = 0; j < n; j++) {
            double tmp = m[i][j];
            m[i][j] = m[first_non_falsy][j];
            m[first_non_falsy][j] = tmp;
        }
        return m;
    }

    private static Pair createPair(final double[][] m, int i, int j) {
        List<Integer> check_result = new ArrayList<>();

        int fnf = -1;
        for (int k = i; k < m.length; k++) {
            check_result.add(m[k][j] != 0 ? 1 : 0);
            if (fnf == -1 && check_result.size() > 0) {
                fnf = k;
            }
        }

        int check_sum = sum(check_result);
        return new Pair(check_sum, fnf);
    }

    public static Integer sum(final List<Integer> list) {
        Integer sum = 0;
        for (Integer i : list)
            sum = sum + i;
        return sum;
    }

    public static double[][] getRows(double[][] x, int[] row) {
        int n = 0;
        for (int aRow : row) {
            if (aRow == 1) {
                ++n;
            }
        }
        double[][] ans = new double[n][x[0].length];
        int r = 0;
        for (int i = 0; i < x.length; i++) {
            if (row[i] == 0) {
                continue;
            }
            for (int j = 0; j < x[i].length; j++) {
                ans[r][j] = x[i][j];
            }
            ++r;
        }

        return ans;
    }

    public static double[] getVector(double[] y, int[] row) {
        int n = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                ++n;
            }
        }
        double[] ans = new double[n];
        int r = 0;
        for (int i = 0; i < y.length; i++) {
            if (row[i] == 0) {
                continue;
            }
            ans[r] = y[i];
            ++r;
        }
        return ans;
    }
}

class Pair {
    final int first;
    final int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
