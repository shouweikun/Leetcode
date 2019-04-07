package quiz1_50;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/2.
 */
public class permutation2 {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backTracking(nums, res, temp, used);
        return res;
    }

    private void backTracking(int[] nums, List<List<Integer>> res, List<Integer> acc, boolean[] used) {


        if (acc.size() == nums.length) res.add(new LinkedList<>(acc));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                if (!used[i]) {
                    used[i] = true;
                    acc.add(nums[i]);
                    backTracking(nums, res, acc, used);
                    used[i] = false;
                    acc.remove(acc.size() - 1);
                }
            }
        }

    }
}
