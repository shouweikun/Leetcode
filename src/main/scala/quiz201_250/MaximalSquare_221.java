package quiz201_250;

/**
 * Created by john_liu on 2018/12/22.
 */
public class MaximalSquare_221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int length = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[length][width];
        int re = 0;
        for (int i = 0; i < length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                re = 1;
            }
        }
        for (int j = 0; j < width; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                re = 1;
            }
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    re = Math.max(dp[i][j], re);
                }
            }
        }
        return re * re;
    }

    public static void main(String[] args) {
        char[][] a = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        new MaximalSquare_221().maximalSquare(a);
    }


}
