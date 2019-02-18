package quiz1_50;

import scala.Int;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/19.
 */
public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> re = new LinkedList<>();
        backTracking(re,new LinkedList<Integer>(),candidates,target,0);
        return re;
    }

    private void backTracking(List<List<Integer>> list, List<Integer> acc, int[] candidates, int target, int curr) {
        if (target < 0) return;
        if (target == 0) {
            list.add(new LinkedList<>(acc));
            return;
        }
        for (int i = curr; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) continue;
            acc.add(candidates[i]);
            backTracking(list, acc, candidates, target - candidates[i], i + 1);
            ((LinkedList<Integer>)acc).removeLast();
        }
    }
}
