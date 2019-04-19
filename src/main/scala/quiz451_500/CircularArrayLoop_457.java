package quiz451_500;

/**
 * Created by john_liu on 2019/4/12.
 */
public class CircularArrayLoop_457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1) return false;
        boolean[] used = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;
            if (nums[i] < 0) continue;
            int slow = i;
            int fast = i;
            used[slow] = true;
            boolean success = true;
            while (true) {
                if (fast >= nums.length || fast < 0 || nums[fast] < 0) {
                    success = false;
                    break;
                }
                used[slow] = true;
                fast = nextIndex(fast, nums[fast], nums.length);
                slow = nextIndex(slow, nums[slow], nums.length);
                if (fast >= nums.length || fast < 0 || nums[fast] < 0) {
                    success = false;
                    break;
                }
                fast = nextIndex(fast, nums[fast], nums.length);
                if (slow == fast) break;
            }
            int index = nextIndex(slow, nums[slow], nums.length);
            if (success && index != slow && index >= 0 && index < nums.length && nums[index] > 0) return success;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;
            if (nums[i] > 0) continue;
            int slow = i;
            int fast = i;
            used[slow] = true;
            boolean success = true;
            while (slow != fast) {
                if (fast >= nums.length || fast < 0 || nums[fast] > 0) {
                    success = false;
                    break;
                }
                used[slow] = true;
                fast = nextIndex(fast, nums[fast], nums.length);
                slow = nextIndex(slow, nums[slow], nums.length);
                if (fast >= nums.length || fast < 0 || nums[fast] > 0) {
                    success = false;
                    break;
                }
                fast = nextIndex(fast, nums[fast], nums.length);
            }
            int index = nextIndex(slow, nums[slow], nums.length);
            if (success && index != slow && index >= 0 && index < nums.length && nums[index] < 0) return success;
        }

        return false;
    }

    private int nextIndex(int currIndex, int step, int loopLength) {
        int tmp = currIndex + step;
        if (tmp < 0) {
            tmp += loopLength;
        }
        return tmp % loopLength;
    }

    public static void main(String[] args) {
        int[] a = {-8, -1, 1, 7, 2};
        new CircularArrayLoop_457().circularArrayLoop(a);
    }
}
