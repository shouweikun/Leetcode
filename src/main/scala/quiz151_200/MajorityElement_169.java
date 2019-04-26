package quiz151_200;

import java.util.Arrays;

/**
 * Created by john_liu on 2019/4/25.
 */
public class MajorityElement_169 {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                count++;
            } else {
                if (count > nums.length / 2) return nums[i];
                count = 1;

            }
        }
        return count;
    }
}
