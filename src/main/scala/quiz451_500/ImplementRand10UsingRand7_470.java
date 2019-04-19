package quiz451_500;

/**
 * Created by john_liu on 2019/4/13.
 */
public class ImplementRand10UsingRand7_470 {
    public int rand7(){
        return 1; //dummy
    }

    public int rand10() {
        int x = Integer.MAX_VALUE;
        while (x > 40)
            x = 7 * (rand7() - 1) + rand7();
        return x % 10 + 1;
    }
}
