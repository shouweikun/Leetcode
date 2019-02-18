package tips.sort;

/**
 * Created by john_liu on 2018/12/4.
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        makeHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, arr.length - 1 - i);
            heapAdjust(arr, i, arr.length - 1 - i - 1);
        }
    }

    private static void makeHeap(int[] arr) {
        for (int i = arr.length / 2 + 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }
    }

    private static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = 2 * start; i <= end; i *= 2) {
            if (i < end && arr[i] < arr[i + 1]) i++;
            if (temp < arr[i]) {
                arr[start] = arr[i];
                arr[i] = temp;
                start = i;
            } else break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
