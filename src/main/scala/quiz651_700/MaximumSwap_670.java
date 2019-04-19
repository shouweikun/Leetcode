package quiz651_700;

/**
 * Created by john_liu on 2019/4/15.
 */
public class MaximumSwap_670 {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int left = 0;
        int right = 0;
        while (left < chars.length && right < chars.length && left == right) {
            right = findMaxIndex(chars, right, chars.length - 1);
            if (right == left||chars[right] == chars[left]) {
                left++;
                right =left;
            }
        }
        if (right == left) return num;
        swap(chars,right,left);
        return Integer.valueOf(new String(chars));

    }

    private int findMaxIndex(char[] chars, int start, int end) {
        if (start == end) return start;
        if (start == end - 1) return chars[start] > chars[end] ? start : end;
        if (start < end) {
            int mid = (start + end) / 2;
            int left = findMaxIndex(chars, start, mid);
            int right = findMaxIndex(chars, mid + 1, end);
            return chars[left] > chars[right] ? left : right;
        }
        return 0;
    }

    private void swap(char[] chars, int p, int q) {
        char tmp = chars[p];
        chars[p] = chars[q];
        chars[q] = tmp;
    }

    public static void main(String[] args) {
        new MaximumSwap_670().maximumSwap(98368);
    }
}
