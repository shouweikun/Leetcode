package quiz51_100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/15.
 */
public class SubSets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(Collections.emptyList());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new LinkedList<>();
            for (List<Integer> l : res) {
                List<Integer> re = new LinkedList<>(l);
                re.add(nums[i]);
                temp.add(re);
            }
            res.addAll(temp);
        }
        return res;
    }
}
