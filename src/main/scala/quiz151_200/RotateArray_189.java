package quiz151_200;

/**
 * Created by john_liu on 2019/4/23.
 */
public class RotateArray_189 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return;
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }


    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }


}
