package quiz51_100;

/**
 * Created by john_liu on 2018/12/17.
 */
public class UniquePaths2_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int length = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] dps = new int[length][width];
        dps[0][0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                int prevI = i - 1;
                int prevJ = j - 1;
                dps[i][j] = dpOperation(i, prevJ, dps) + dpOperation(prevI, j, dps);
                System.out.println(""+i+","+"j");
                System.out.println(dps[i][j]);
            }
        }
        return dps[length][width];
    }

    private int dpOperation(int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        return dp[i][j];
    }
}
