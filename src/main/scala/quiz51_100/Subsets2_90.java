package quiz51_100;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/25.
 */
public class Subsets2_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backtracking(res, nums, new LinkedList<>(), 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, int[] nums, LinkedList<Integer> tmp, int start) {
        res.add(new LinkedList<>(tmp));
        for (int i = start; i < nums.length; i++) {

            tmp.add(nums[i]);

            backtracking(res, nums, tmp, i + 1);
            tmp.removeLast();
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
        }
    }
}
