package tips;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john_liu on 2018/8/24.
 *
 * kSum思路
 * 1.将ksum 拆解成 k-1sum 和 k
 * 2.递归，递归栈顶为k =2
 */
public class KSum {
    /**
     *
     * @param nums
     * @param start
     * @param k
     * @param target
     * @return
     */
    private List<List<Integer>> kSum (int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(k == 2) { //two pointers from left and right
            int left = start, right =
                    - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) { //move left
                    left++;
                } else { //move right
                    right--;
                }
            }
        } else {
            for(int i = start; i < len - (k - 1); i++) {
                if(i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for(List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }
        return res;
    }
}
