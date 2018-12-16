package quiz1_50;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/16.
 */
public class CombinationSum_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        List<List<Integer>> temp = new LinkedList<>();
        temp.add(Collections.emptyList());
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            for (List<Integer> l : temp) {
                ( (LinkedList<Integer>)l).add(candidates[i]);
                int sum =  sumList(l);
                if(sum>target) {
                    temp.remove(l);
                    continue;
                }
               if(sum == target) {
                   res.add(l);
                   temp.remove(l);
               }
            }
        }

        return res;
    }

    private int sumList(List<Integer> list){
        return list.stream().mapToInt(x->x).sum();
    }
}
