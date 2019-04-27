package quiz301_350;

import scala.Int;

import java.util.Arrays;

/**
 * Created by john_liu on 2019/4/27.
 */
public class LongestIncreasingPathinaMatrix_329 {
    int[][] dfsContent;
    int max = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        dfsContent = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfsContent[i][j] != 0) continue;
                dfs(matrix, i, j);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (dfsContent[i][j] != 0) return dfsContent[i][j];
        int re = 0;
        if (isCandidate(matrix, i - 1, j, matrix[i][j])) re = dfs(matrix, i - 1, j);
        if (isCandidate(matrix, i + 1, j, matrix[i][j])) re = Math.max(dfs(matrix, i + 1, j), re);
        if (isCandidate(matrix, i, j - 1, matrix[i][j])) re = Math.max(dfs(matrix, i, j - 1), re);
        if (isCandidate(matrix, i, j + 1, matrix[i][j])) re = Math.max(dfs(matrix, i, j + 1), re);
        re++;
        max = Math.max(re, re);
        dfsContent[i][j] = re;
        return re;

    }

    private boolean isCandidate(int[][] matrix, int row, int col, int current) {
        if (row < 0 || col < 0) {
            return false;
        }
        if (row >= matrix.length) {
            return false;
        }

        if (col >= matrix[0].length) {
            return false;
        }

        if (current <= matrix[row][col]) {
            return false;
        }
        return true;
    }

}