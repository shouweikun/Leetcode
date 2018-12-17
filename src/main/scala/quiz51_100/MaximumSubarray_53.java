package quiz51_100;

/**
 * Created by john_liu on 2018/12/5.
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
          int max = Integer.MIN_VALUE;
          int sum = 0;

          for(int i = 0;i<nums.length;i++){
               if(sum<0) sum = nums[i];
               else sum = sum + nums[i];

               if(max<sum) max = sum;
          }

          return max;
    }
}
