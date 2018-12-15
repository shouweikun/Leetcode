package quiz401_450;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by john_liu on 2018/11/28.
 */
public class FindAllAnagramsnaString_438 {

//    public List<Integer> findAnagrams(String s, String p) {
//        char[] fromP = p.toCharArray();
//        Map<Character, Integer> map = new HashMap<>(fromP.length);
//        Integer temp;
//        int length = fromP.length;
//        int count;
//        for (char c : fromP) {
//            if (map.containsKey(c)) {
//                temp = map.get(c);
//                map.put(c, temp + 1);
//            } else map.put(c, 1);
//        }
//        int step;
//        for (int i = 0; i <= s.length() - p.length(); i++) {
//            for (step = 0; step < p.length(); step++) {
//                boolean hit = this.mapRemoveOperation(map, s[i + step]);
//            }
//        }
//
//    }

    private boolean mapRemoveOperation(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            int temp = map.get(c);
            temp = temp - 1;
            if (temp == 0) map.remove(c);
            else map.put(c, temp);
            return true;
        } else return false;
    }
}
