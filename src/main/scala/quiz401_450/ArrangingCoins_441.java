package quiz401_450;

/**
 * Created by john_liu on 2018/12/12.
 */
public class ArrangingCoins_441 {
    public int arrangeCoins(int n) {
        int re = 0;
        for(int i =1;i<=n;i++){
            re++;
            n = n-i;
        }
        return re;
    }

    public static void main(String[] args) {
       new ArrangingCoins_441().arrangeCoins(8);
    }
}
