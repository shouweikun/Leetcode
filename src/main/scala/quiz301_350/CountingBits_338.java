package quiz301_350;

/**
 * Created by john_liu on 2019/4/20.
 */
public class CountingBits_338 {
    public int[] countBits(int num) {
        int[] re = new int[num + 1];
        int length = 1;
        int base = 1;
        while (base < num) {
            length++;
            base = base << 1;
        }
        int[] iter = new int[length];
        int count = 0;
        int index = 0;
        for (int i = 1; i <= num; i++) {
            while (index < length) {
                if (iter[index] == 1) {
                    iter[index] = 0;
                    count--;
                    index++;
                } else {
                    iter[index] = 1;
                    count++;
                    break;
                }
            }
            re[i] = count;
            index = 0;
        }

        return re;
    }

    public int[] countBits_2(int num) {
        int[] re = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            re[i] = re[(i & i - 1)] + 1;
        }
        return re;
    }
}
