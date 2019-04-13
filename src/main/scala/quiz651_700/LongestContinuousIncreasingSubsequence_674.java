package quiz651_700;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/7.
 */
public class LongestContinuousIncreasingSubsequence_674 {

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length <= 1) return nums.length;
        List<Integer> re = new ArrayList<>();
        re.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = findmatchIndex(re, nums[i]);
            if (index == -1) re.add(nums[i]);
            else re.set(index, nums[i]);
        }
        return re.size();

    }

    private int findmatchIndex(List<Integer> list, int target) {
        if (list.get(0) >= target) return 0;
        if (list.get(list.size() - 1) < target) return -1;
        int low = 0;
        int high = list.size() - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (list.get(mid) == target) return mid;
            if (list.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }


    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        new LongestContinuousIncreasingSubsequence_674().findLengthOfLCIS(arr);
    }
}
