package quiz1_50;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/21.
 *
 * @note 一道简单的回溯题 ，注意的点是通过开始索引的继承避免重复
 * 排序很重要
 */
public class CombinationSum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        backTracking(res, candidates, target, new LinkedList<>(), 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, int[] candidates, int target, LinkedList<Integer> tmp, int start) {
        if (target == 0) res.add(new LinkedList<>(tmp));
        else {
            for (int i = start; i < candidates.length; i++) {
                if (target < candidates[i]) continue;
                tmp.add(candidates[i]);
                backTracking(res, candidates, target - candidates[i], tmp, i);
                tmp.removeLast();
            }
        }
    }
}
