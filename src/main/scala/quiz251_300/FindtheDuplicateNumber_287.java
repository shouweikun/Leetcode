package quiz251_300;

/**
 * Created by john_liu on 2019/4/10.
 */
public class FindtheDuplicateNumber_287 {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
