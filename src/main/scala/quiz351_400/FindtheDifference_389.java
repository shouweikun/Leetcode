package quiz351_400;

import scala.Char;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by john_liu on 2018/11/28.
 */
public class FindtheDifference_389 {
    public char findTheDifference(String s, String t) {
        char[] fromS = s.toCharArray();
        char[] fromT = t.toCharArray();
        Integer temp;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (fromS[i] == fromT[i]) continue;
            if (map.containsKey(fromS[i])) {
                temp = map.get(fromS[i]);
                temp = temp + 1;
                if (temp != 0) map.put(fromS[i], temp);else map.remove(fromS[i]);
            } else map.put(fromS[i], 1);
            if (map.containsKey(fromT[i])) {
                temp = map.get(fromT[i]);
                temp = temp - 1;
                if (temp != 0) map.put(fromT[i], temp);else map.remove(fromT[i]);
            } else map.put(fromT[i], -1);
        }
        if (map.containsKey(fromT[t.length() - 1])) {
            temp = map.get(fromT[t.length() - 1]);
            temp = temp - 1;
            if (temp != 0) map.put(fromT[t.length() - 1], temp);else map.remove(fromT[t.length() - 1]);
        }else map.put(fromT[t.length() - 1], -1);
        return map.keySet().iterator().next();
    }

    public static void main(String[] args) {
        new FindtheDifference_389().findTheDifference("abcd", "abcde");
    }
}
