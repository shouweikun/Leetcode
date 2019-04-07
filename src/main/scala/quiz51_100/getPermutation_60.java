package quiz51_100;

/**
 * Created by john_liu on 2019/4/2.
 */
public class getPermutation_60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] nFactorial = new int[n];
        nFactorial[0] = 1;
        for (int i = 1; i < n; i++) nFactorial[i] = (i + 1) * nFactorial[i - 1];
        for (int i = 0; i < n; i++) {
            int num = findMatchNum(k, nFactorial[n - i - 1]);
            sb.append(num);
            k = k - num * nFactorial[n - i - 1];
        }
       return sb.toString();
    }

    private int findMatchNum(int k, int factoringBase) {
        int factoring = factoringBase;
        for (int i = 1; i <= 8; i++) {
            if (k < factoring) return i;
            factoring = factoringBase + factoring;
        }
        return 9;
    }
}
