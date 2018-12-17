package quiz1_50;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/8/24.
 * 使用kSum
 */
public class _4Sum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       if(nums.length<4) return Collections.emptyList();
       return kSum(nums,0,4,target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (k == 2) {
            int right = nums.length - 1;
            int left = start;
            int sum = nums[right] + nums[left];
            while (left < right) {
                if (sum == target) {
                    List<Integer> re = new LinkedList<>();
                    re.add(left);
                    re.add(right);
                    res.add(re);
                 while(nums[left] == nums[left+1] && left<right)left++;
                 while(nums[right] == nums[right-1] && left<right)right --;
                 left--;
                 right++;
            } else if (sum>target) right--;else left++;
        }
    } else{
            for(int i =start;i<nums.length-i+1;i++){
                if(i >start && nums[i] ==nums[i-1]) continue;
                List<List<Integer>> temp = kSum(nums,i+1,k-1,target-nums[i]);
                for(List<Integer>t: temp){
                    t.add(0,nums[i]);
                }
                res.addAll(temp);
            }
        }
        return res;
    }

}
