package quiz1_50;

import java.util.Arrays;

/**
 * Created by john_liu on 2019/4/11.
 */
public class FindFirstandLastPositionofElementinSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] re = {-1, -1};
        if (nums.length <= 0) return re;
        int lowBound = findFirstGteIndexOfArray(nums, target);
        int highBound = findLastGteIndexOfArray(nums, target);
        if (lowBound > nums.length - 1 || highBound < 0) return re;
        if (lowBound > highBound) return re;
        re[0] = lowBound;
        re[1] = highBound;
        return re;
    }

    private int findFirstGtIndexOfArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    private int findLastLtIndexOfArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) high = mid - 1;
            else low = mid + 1;
        }
        return high;
    }

    private int findFirstGteIndexOfArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;

    }

    private int findLastGteIndexOfArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 3, 3, 3, 3, 3, 5};
        new FindFirstandLastPositionofElementinSortedArray_34().searchRange(arr1, 1);
    }
}
