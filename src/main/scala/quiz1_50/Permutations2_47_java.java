package quiz1_50;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/19.
 */
public class Permutations2_47_java {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> re = new LinkedList<>();
        backTracking(re,new LinkedList<>(),nums,new boolean[nums.length]);
        return re;
    }

    private void backTracking(List<List<Integer>> list, List<Integer> acc, int[] nums, boolean[] used) {
        if (acc.size() == nums.length) {
            list.add(acc);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true || i>0&&used[i - 1] && nums[i] == nums[i - 1]) continue;
            acc.add(nums[i]);
            used[i] = true;
            backTracking(list, acc, nums, used);
            used[i] = false;
            ((LinkedList<Integer>)acc).removeLast();
        }
    }
}
