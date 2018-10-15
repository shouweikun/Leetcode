package quiz1_50;

/**
 * Created by john_liu on 2018/10/15.
 */
public class NextPermutation_31_Java {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) i--;
        if (i != 0) {
            int j = nums.length -
                    1;
            while (j >= i && nums[j] <= nums[i - 1]) j--;
            swap(nums, i - 1, j);
        }
        reverse(nums, i, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }
}
