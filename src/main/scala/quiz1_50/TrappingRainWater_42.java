package quiz1_50;

/**
 * Created by john_liu on 2019/4/8.
 */
public class TrappingRainWater_42 {

    public int trap(int[] height) {
        if (height.length <= 1) return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        int count = 0;
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            count += Math.min(left[i], right[i]) - height[i];
        }
        return count;
    }
}
