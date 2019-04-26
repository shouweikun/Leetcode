package quiz451_500;

import java.util.*;

/**
 * Created by john_liu on 2019/4/26.
 */
public class IncreasingSubsequences_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        List<List<Integer>> res = new LinkedList<>();

        backtracking(res, nums, new LinkedList(), 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, int[] nums, LinkedList<Integer> tmp, int start) {
        if (tmp.size() >= 2) {
            res.add(new ArrayList<>(tmp));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            if (!tmp.isEmpty() && tmp.getLast() > nums[i]) continue;
            if (tmp.isEmpty()) set.add(nums[i]);
            tmp.add(nums[i]);
            set.add(nums[i]);
            backtracking(res, nums, tmp, i + 1);
            tmp.removeLast();

        }
    }
}
