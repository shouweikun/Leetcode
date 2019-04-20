package quiz1_50;

/**
 * Created by john_liu on 2019/4/2.
 */
public class next_Permutation_31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] >= nums[index + 1]) index--;
            else break;
        }
        if (index >= 0) {
            int j = nums.length - 1;
            while (j > index && nums[j] <= nums[index]) j--;

            swap(nums,index,j);
        }
        reverse(nums, index+1, nums.length - 1);
    }

    private void swap(int[] arr, int q, int p) {
        int swap = arr[q];
        arr[q] = arr[p];
        arr[p] = swap;
    }

    private void reverse(int[] arr, int start, int end) {
        if (arr == null) return;
        if (start >= end) return;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
