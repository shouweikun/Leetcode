package quiz201_250;

/**
 * Created by john_liu on 2018/12/22.
 */
public class Searcha2DMatrix2_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int length = matrix.length;
        int width = matrix[0].length;
        if (width == 0) return false;
        return searchMatrix2D(matrix, target, length, width);

    }

    private boolean searchMatrix2D(int[][] matrix, int target, int length, int width) {

        boolean re = false;
        int x = 0, y = 0;
        int high, low;
        while (true) {
            x = verticalSearch2D(matrix, target, y, length - 1, x);
            if (x == -1) return false;
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) {
                
            }
            y = horizationalSearch2D(matrix, target, x, width - 1, y);
            if (y == -1) return false;
            if (matrix[x][y] == target) return true;

        }
    }

    private int verticalSearch2D(int[][] matrix, int target, int startColumnIndex, int endIndex, int startIndex) {
        if (matrix[startIndex][startColumnIndex] > target || matrix[endIndex][startColumnIndex] < target) return -1;
        if (matrix[endIndex][startColumnIndex] == target) return endIndex - 1;
        int low = startIndex;
        int high = endIndex;

        while (low < high - 1) {
            int middle = (low + high) / 2;
            if (matrix[middle][startColumnIndex] > target) high = middle;
            else if (matrix[middle][startColumnIndex] == target) return middle;
            else low = middle;
        }
        return low;
    }

    private int horizationalSearch2D(int[][] matrix, int target, int startRowIndex, int endIndex, int startIndex) {
        if (matrix[startRowIndex][endIndex] < target) return -1;
        int low = startIndex;
        int high = endIndex;
        while (low < high - 1) {
            int middle = (low + high) / 2;
            if (matrix[startRowIndex][middle] > target) high = middle;
            else if (matrix[startRowIndex][middle] == target) return middle;
            else low = middle;
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr0 = {1, 4, 7, 11, 15};
        int[] arr1 = {2, 5, 8, 12, 19};
        int[] arr2 = {3, 6, 9, 16, 22};
        int[] arr3 = {10, 13, 14, 17, 24};
        int[] arr4 = {18, 21, 23, 26, 30};
        int[][] arr = {arr0, arr1, arr2, arr3, arr4};

//     arr[1] =arr1;
        new Searcha2DMatrix2_240().searchMatrix(arr, 5);
    }
}
