package quiz251_300;

/**
 * Created by john_liu on 2019/4/11.
 */
public class SingleNumber3_260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) xor ^= nums[i];
        int a = 0;
        int b = 0;
        int mark = xor & -xor;
        for (int var : nums) {
            if ((mark & var) == 0) {
                a ^= var;
            } else if ((mark & var) == mark) {
                b ^= var;
            }
        }
        int[] re= {a, b};
        return re;
    }
}
