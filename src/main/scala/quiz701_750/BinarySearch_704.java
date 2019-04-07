package quiz701_750;

/**
 * Created by john_liu on 2018/12/24.
 */
public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (true) {
            middle = (low + high) / 2;
            if (nums[middle] == target) {
               return middle;
            }
            if (nums[middle] > target) high = middle;
            else low = middle;

            if (high - low <= 1) {
             if(nums[high] == target) return high;
             if(nums[low] == target) return low;
             return -1;
            }
        }

    }
}
