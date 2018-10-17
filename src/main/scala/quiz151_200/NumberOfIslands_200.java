package quiz151_200;

/**
 * Created by john_liu on 2018/10/17.
 */
public class NumberOfIslands_200 {

    public int numIslands(char[][] grid) {

        int length = grid.length;
        if (length == 0) return 0;
        int re = 0;
        int width = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                re += dfs(i, j, grid);
            }
        }

        return re;
    }

    public int dfs(int i, int j, char[][] grid) {

        int length = grid.length;
        int width = grid[0].length;
        if (i < 0 || j < 0 || i >= length || j >= width
                ||grid[i][j] !='1') return 0;

        grid[i][j] = '0';
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        return 1;

    }
}
