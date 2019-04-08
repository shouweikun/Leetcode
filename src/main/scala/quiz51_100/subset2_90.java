package quiz51_100;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/8.
 */
public class subset2_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) return Collections.EMPTY_LIST;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        backtracking(nums, res, new LinkedList<>(), 0);
        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> acc, int start) {
        res.add(new LinkedList(acc));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            acc.add(nums[i]);
            backtracking(nums, res, acc, i + 1);
            acc.remove(acc.size() - 1);
        }
    }
}
