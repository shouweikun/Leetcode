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
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == '0') continue;
                int p1 = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                int p2 = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
                int p3 = (j > 0 && i > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;

                if(re<dp[i][j]) re = dp[i][j];
            }
        }
        return re *re ;
    }



}
