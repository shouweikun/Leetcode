package quiz201_250;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/1/9.
 */
public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        if(nums ==null ||nums.length ==0) return Collections.emptyList();
        List<String> re = new LinkedList<>();
        int prefix = nums[0];
        int suffix = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if(nums[i] == nums[i-1]+1) suffix = nums[i];
            else{
                if(prefix == suffix) re.add(String.valueOf(prefix));
                else re.add(String.valueOf(prefix)+ "->"+ String.valueOf(suffix));
                prefix = nums[i];
                suffix = nums[i];
            }
        }
        if(prefix == suffix) re.add(String.valueOf(prefix));
        else re.add(String.valueOf(prefix)+ "->"+ String.valueOf(suffix));
        return re;
    }
}
