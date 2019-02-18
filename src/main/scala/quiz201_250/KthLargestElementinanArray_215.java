package quiz201_250;

/**
 * Created by john_liu on 2018/12/25.
 */
public class KthLargestElementinanArray_215 {

    public int findKthLargest(int[] nums, int k) {
        makeHeap(nums);
        return takeK(nums, k);
    }

    private void makeHeap(int[] nums) {
        for (int i = nums.length/2; i >= 0; i--) {
//        for (int i = 0; i < nums.length/2; i++) {
            adjustHeap(nums, i, nums.length - 1);
        }
    }

    private int takeK(int[] nums, int k) {
        int index;
        for (int i = 0; i < k-1; i++) {
          index =   nums.length-1-i;
         swap(0,index,nums);
         adjustHeap(nums,0,index-1);
        }
        return nums[0];
    }

    private void swap(int left, int right, int[] nums) {
       int temp = nums[left];
       nums[left] = nums[right];
       nums[right] = temp;
    }

    private void adjustHeap(int[] nums, int start, int end) {
        for (int i = 2*start+1; i <= end; i = 2*i+1) {
            if (i < end && nums[i + 1] > nums[i]) i++;
            if (nums[start] > nums[i]) break;
            swap(start,i,nums);
            start = i;
        }

    }

    public static void main(String[] args) {
        int [] a = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};



        new KthLargestElementinanArray_215().findKthLargest(a,2);
    }
}
