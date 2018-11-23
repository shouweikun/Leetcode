package tips.sort;

/**
 * Created by john_liu on 2018/11/23.
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) return;
        if (right - left == 1) {
            if (arr[right] < arr[left]) swap(arr, right, left);
            return;
        }
        int pivot = (right + left) / 2;
        mergeSort(arr, pivot + 1, right);
        mergeSort(arr, left, pivot);
        mergeCore(arr, left, pivot, right);
    }

    private static void mergeCore(int[] arr, int left, int pivot, int right) {
        int middle = pivot;
        int down = (middle - 1) - left + 1;
        int upper = right - (middle) + 1;
        int count = 0;
        int[] temp = new int[down + upper];

        while (down != 0 && upper != 0) {
            if (arr[left] < arr[middle]) {
                temp[count] = arr[left];
                down--;
            } else {
                temp[count] = arr[middle];
                upper--;
            }
            count++;
        }
        if (down != 0) while (down != 0) {
            temp[count] = arr[down];
            count++;
            down--;
        }
        else if (upper != 0) while (upper != 0) {
            temp[count] = arr[upper];
            count++;
            upper--;
        }


    }

    private static void swap(int[] arr, int left, int right) {
        if (left == right) return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
