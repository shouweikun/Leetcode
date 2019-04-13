package quiz201_250;

/**
 * Created by john_liu on 2018/12/22.
 */
public class Searcha2DMatrix2_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
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
