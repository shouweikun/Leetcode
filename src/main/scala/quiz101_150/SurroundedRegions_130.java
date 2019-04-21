package quiz101_150;

/**
 * Created by john_liu on 2019/4/21.
 */
public class SurroundedRegions_130 {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int top = 0, bottom = board.length - 1, left = 0, right = board[0].length - 1;
        for (int i = left; i <= right; i++) bfs(board, top, i);
        top++;
        for (int i = top; i <= bottom; i++) bfs(board, i, right);
        right--;
        for (int i = right; i >= left; i--) bfs(board, bottom, i);
        bottom--;
        for (int i = bottom; i >= top; i--) bfs(board, i, left);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'L') board[i][j] = 'O';
            }
        }

    }


    private void bfs(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O') {
            board[i][j] = 'L';
            bfs(board, i + 1, j);
            bfs(board, i - 1, j);
            bfs(board, i, j + 1);
            bfs(board, i, j - 1);
        }
    }
}
