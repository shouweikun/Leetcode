package tips.sort;

import java.util.Arrays;

/**
 * Created by john_liu on 2018/11/22.
 */


public class QuickSort {

    public static void quickSort(int[] arr, int left, int right, boolean desc) {
        if (arr == null) return;
        if (right == left) return;
        if (right - left == 1) {
            if (arr[right] > arr[left] != desc) swap(arr, left, right);
            return;
        }
        int pivot = right;
        int nextR = right;
        int nextL = left;
        right = right - 1;
        while (right != left) {
            if (desc) {
                if (arr[pivot] >= arr[right]) {
                    swap(arr, left, right);
                    left = left + 1;
                } else {
                    right = right - 1;

                }
            } else {
                if (arr[pivot] <= arr[right]) {
                    swap(arr, left, right);
                    if (arr[left] > arr[pivot]) left = left + 1;
                    left = left + 1;
                } else {
                    swap(arr, left, right);
                    if (arr[pivot] <= arr[right]) right = right - 1;
                }
            }
        }
        swap(arr, pivot, left);
        pivot = right;
        quickSort(arr, nextL, pivot - 1, desc);
        quickSort(arr, pivot + 1, nextR, desc);

    }

    private static void swap(int[] arr, int left, int right) {
        if (left == right) return;
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] szm = {3, 2, 45, 5352, 1, 6, 1343, 1};
        quickSort(szm, 0, szm.length - 1, true);
        System.out.print("");

    }
}