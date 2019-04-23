package quiz51_100;

import scala.Int;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/24.
 */
public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || n < k) return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();
        backTracking(res, new LinkedList<>(), 1, k, n);
        return res;
    }

    private void backTracking(List<List<Integer>> res, LinkedList<Integer> tmp, int start, int k, int n) {
        if (tmp.size() == k) {
            res.add(new LinkedList<>(tmp));
        }
        for (int i = start; i <= n; i++) {
            if (n - i+1 < k - tmp.size()) break;
            tmp.add(i);
            backTracking(res, tmp, i + 1, k, n);
            tmp.removeLast();
        }
    }
}
