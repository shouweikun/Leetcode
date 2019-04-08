package quiz1_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/7.
 *
 * @author john_liu
 */
public class _3sum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(3, nums, 0, 0);
    }

    public List<List<Integer>> kSum(int k, int nums[], int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (k == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        } else {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                int newTaregt = target - nums[i];
                List<List<Integer>> temp = kSum(k - 1, nums, i + 1, newTaregt);
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }

        return res;
    }
}
