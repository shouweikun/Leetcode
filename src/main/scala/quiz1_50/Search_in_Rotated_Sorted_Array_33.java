package quiz1_50;

/**
 * Created by john_liu on 2019/4/7.
 */
public class Search_in_Rotated_Sorted_Array_33 {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < nums[high]) {
            if (nums[mid] < target && target <= nums[high]) return search(nums, target, mid + 1, high);
            else return search(nums, target, low, mid - 1);
        } else {
            if (nums[mid] > target && target >= nums[low]) return search(nums, target, low, mid - 1);
            else return search(nums, target, mid + 1, high);
        }
    }
}
