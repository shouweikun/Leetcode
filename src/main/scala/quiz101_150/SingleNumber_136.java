package quiz101_150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by john_liu on 2018/12/5.
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int temp;
        for(int i =0;i<nums.length;i++){
            if(set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        return set.iterator().next();

    }
}
