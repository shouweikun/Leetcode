package quiz101_150;

import scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/7.
 *
 *
 * @note 对待数组，首先考虑是否可以排序解决问题
 */
public class LongestConsecutiveSequence_128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                if (nums[i] == nums[i + 1]) continue;
                if (nums[i] + 1 == nums[i + 1]) count++;
                else {
                    max = Math.max(count, max);
                    count = 1;
                }
            } else {
                max = Math.max(count, max);
            }
        }

        return max;
    }


}
