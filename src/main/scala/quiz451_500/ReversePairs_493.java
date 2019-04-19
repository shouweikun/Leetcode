package quiz451_500;

/**
 * Created by john_liu on 2019/4/14.
 *
 * @author john_liu
 * @note 使用归并排序解
 */
public class ReversePairs_493 {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        return sortAndCount(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private int sortAndCount(int[] nums, int low, int high, int[] tmp) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += sortAndCount(nums, low, mid, tmp);
            count += sortAndCount(nums, mid + 1, high, tmp);
            count += countPair(nums, low, mid, high);
            merge(nums, low, mid, high, tmp);
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high, int[] tmp) {
        int i = 0;
        int j = low;
        int k = mid + 1;
        while (j <= mid && k <= high) {
            if (nums[j] < nums[k]) {
                tmp[i++] = nums[j++];
            } else tmp[i++] = nums[k++];
        }
        while (j <= mid) tmp[i++] = nums[j++];
        while (k <= high) tmp[i++] = nums[k++];
        System.arraycopy(tmp, 0, nums, low, i);
    }

    private int countPair(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int count = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= 2l * nums[j]) i++;
            else {
                count += mid - i + 1;
                j++;
            }
        }

        return count;
    }
}
