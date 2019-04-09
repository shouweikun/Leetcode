package quiz651_700;

/**
 * Created by john_liu on 2019/4/7.
 */
public class Max_Area_of_Island_695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int length = grid.length;
        int width = grid[0].length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                max = Math.max(max, areaOfIsland(grid, i, j, length, width));
            }
        }
        return max;
    }

    private int areaOfIsland(int[][] grid, int i, int j, int length, int width) {
        if (grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int area = 1;
        if (i > 0) area += areaOfIsland(grid, i - 1, j, length, width);
        if (i < length - 1) area += areaOfIsland(grid, i + 1, j, length, width);
        if (j > 0) area += areaOfIsland(grid, i, j - 1, length, width);
        if (j < width - 1) area += areaOfIsland(grid, i, j + 1, length, width);
        return area;
    }
}
