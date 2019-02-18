package quiz201_250;

/**
 * Created by john_liu on 2018/12/25.
 */
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int min = 0;
        int sum = 0;
        int length = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                length--;
                sum = sum - nums[i - 1];
            }
            while (sum < s) {
                if (j >= nums.length) break;
                sum += nums[j];
                length++;
                j++;

            }
            if (sum >= s) {
                if(min ==0) min = length;
                else min = Math.min(length, min);
            } else break;
        }

        return min;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        new MinimumSizeSubarraySum_209().minSubArrayLen(7,arr);
    }
}
