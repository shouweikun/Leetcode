package quiz351_400;

/**
 * Created by john_liu on 2018/12/15.
 */
public class WiggleSubsequence_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) return 0;
        if (nums.length<= 1) return nums.length;
        boolean lastIsUpperSequence = false;
        int re = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] < nums[i - 1]) lastIsUpperSequence = true;
                i++;
                re++;
                break;
            }
            i++;
        }
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (lastIsUpperSequence ^nums[i] < nums[i - 1]) {
                re++;
                lastIsUpperSequence = !lastIsUpperSequence;
            }
        }

        return re;
    }
}
