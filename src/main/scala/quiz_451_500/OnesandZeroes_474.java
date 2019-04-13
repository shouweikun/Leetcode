package quiz_451_500;

/**
 * Created by john_liu on 2019/4/11.
 */
public class OnesandZeroes_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        boolean[] used = new boolean[strs.length];
        int[] re = new int[1];


        return re[0];
    }

    private void backTracking(String[] strs, boolean[] used, int count, int[] re) {
        for (int i = 0; i < strs.length; i++) {
            if (used[i] == true) continue;
            used[i] = true;


            used[i] = false;
        }
    }


}
