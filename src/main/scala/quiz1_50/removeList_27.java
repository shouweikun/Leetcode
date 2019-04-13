package quiz1_50;

/**
 * Created by john_liu on 2019/4/9.
 */
public class removeList_27 {
    public int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        int left = 0;
        while (right >= 0) {
            while (right >= 0 && nums[right] == val) {
                right--;
            }
            while (left < right && nums[left] != val) {
                left++;
            }
            if (right > left) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            } else break;
        }
        return right + 1;
    }


    public static void main(String[] args) {
        // int[] arr = {3, 2, 2, 3};
        int[] arr = {1};
        new removeList_27().removeElement(arr, 3);
    }
}