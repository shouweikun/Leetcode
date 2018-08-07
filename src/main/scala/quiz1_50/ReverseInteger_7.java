package quiz1_50;

import scala.Int;

/**
 * Created by john_liu on 2018/7/29.
 */
public class ReverseInteger_7 {
    public int reverse(int x) {

        boolean isNegative = x < 0;

        char[] cArray =  String.valueOf(Math.abs(x)).toCharArray();
        int length = cArray.length;
        StringBuilder sb = new StringBuilder();
        for(int i = length-1;i>=0;i--){
              sb.append(cArray[i]);
        }
        long re = isNegative? 0-Long.valueOf(sb.toString()):Long.valueOf(sb.toString());
        return  (int)re;
    }

    public int reverse2(int x) {
        int re = 0;
        long compare = 0l;
        int maxLast = Integer.MAX_VALUE % 10;
        int minLast = Integer.MIN_VALUE %10;
        while(x !=0){
            int current = x%10;
            x = x/10;
            compare = compare *10 + current;
            if(compare>Integer.MAX_VALUE || compare <Integer.MIN_VALUE){
                return 0;
            }else {
                re = (int) compare;
            }
        }
        return re;
    }
}
