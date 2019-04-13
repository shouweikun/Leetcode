package quiz151_200;

/**
 * Created by john_liu on 2019/4/10.
 */
public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) return 0;
       return recFindMax(nums, 0, nums.length - 1);
    }

    private int recFindMax(int[] nums, int start, int end) {
        if (start == end) return start;
        if (start == end - 1) return nums[start] > nums[end] ? start : end;
        int mid = (start + end) / 2;
        int right = recFindMax(nums, start, mid);
        int left = recFindMax(nums, mid + 1, end);
        return nums[right] > nums[left] ? right : left;
    }
}
