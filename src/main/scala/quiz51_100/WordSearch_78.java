package quiz51_100;

/**
 * Created by john_liu on 2019/1/30.
 */
public class WordSearch_78 {
    public boolean exist(char[][] board, String word) {
     return brackTracking(word.toCharArray(),board,0,0,0,word.length());
    }

    private boolean brackTracking(char[] word, char[][] board, int i, int j, int index, int wordLength) {
        if (index == wordLength) return true;
        if (i >= board.length || j >= board[0].length) return false;
        if (board[i][j] == word[index]) index++;
        return brackTracking(word, board, i + 1, j, index, wordLength) || brackTracking(word, board, i, j - 1, index, wordLength);
    }
}
