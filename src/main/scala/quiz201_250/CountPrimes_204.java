package quiz201_250;

/**
 * Created by john_liu on 2018/11/28.
 */
public class CountPrimes_204 {

    public int countPrimes(int n) {
        if (n == 1 || n == 0) return 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
           if(isPrime(i)) count+=i;
        }
        return count;
    }

    private boolean isPrime(int n) {
        int temp = (int) Math.sqrt(n) + 1;
        for (int i = 2; i <= temp; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
