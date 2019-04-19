package quiz201_250;

/**
 * Created by john_liu on 2019/4/13.
 */
public class ProductofArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 0) return new int[0];
        int[] re = new int[nums.length];
        re[0] = 1;
        re[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            re[i] = nums[i - 1] * re[i - 1];
        }
        int acc = 1;
        for (int i = nums.length - 1; i >= 0; i++) {
            re[i] *= acc;
            acc *= nums[i];
        }
        return re;
    }
}
