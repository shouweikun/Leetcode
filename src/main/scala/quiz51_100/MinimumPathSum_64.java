package quiz51_100;

/**
 * Created by john_liu on 2018/12/17.
 */
public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int length = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int prevI = i-1;
                int prevJ = j-1;
                dp[i][j] =grid[i][j] + Math.min(dpOperation(i,prevJ,dp),dpOperation(prevI,j,dp));
            }
        }
        return dp[length-1][width-1];
    }

    public int dpOperation(int i,int j,int[][]dp){
        if(i<0 ||j<0) return Integer.MAX_VALUE;
        return dp[i][j];
    }
}
