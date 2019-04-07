package quiz101_150;

/**
 * Created by john_liu on 2018/12/19.
 */
public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max, min, re,temp;
        max = nums[0];
        min = nums[0];
        re = nums[0];

        for (int i = 1; i < nums.length; i++) {
            temp = max;
            max = Math.max(Math.max(min*nums[i],nums[i]*max),nums[i]);
            min = Math.min(Math.min(min*nums[i],nums[i]*temp),nums[i]);
            re = Math.max(re,max);
        }

        return re;
    }

    public static void main(String[] args) {
        int [] a = {-4,-3,-2};
        new MaximumProductSubarray_152().maxProduct(a);
    }
}
