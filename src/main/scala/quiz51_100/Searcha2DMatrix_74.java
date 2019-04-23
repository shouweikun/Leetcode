package quiz51_100;

/**
 * Created by john_liu on 2019/4/23.
 */
public class Searcha2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                return binarySearch(matrix[i], target);
            }
            if (matrix[i][matrix[0].length - 1] < target) return false;
        }

        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) return true;
            if (target > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
