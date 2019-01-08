package quiz201_250;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/1/8.
 */
public class CombinationSum3_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        backtracking(res,temp,n,0,k);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> temp, int target, int start, int n) {
        if (target < start) return;
        if (n == 1) {
            temp.add(target);
            res.add(new LinkedList<>(temp));
        } else {
            for (int i = start; i <= 9; i++) {
                if (target < i) break;
                temp.add(i);
                backtracking(res, temp, target - i, i + 1, n - 1);
                ((LinkedList<Integer>) temp).removeLast();
            }
        }
    }
}
