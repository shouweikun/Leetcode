package quiz251_300;

import java.util.*;

/**
 * Created by john_liu on 2018/11/27.
 */
public class BullsandCows_299 {
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[] visited = new int[g.length];
        int cow = 0;
        int bull = 0;
        Queue<Integer> temp;
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == g[i]) {
                bull++;
                visited[i] = 1;
                continue;
            }
            if (map.containsKey(g[i])) {

                temp = map.get(g[i]);
                if (!temp.isEmpty()) {
                    cow++;
                    visited[i] = 1;
                    temp.poll();
                }

            }
            if (map.containsKey(s[i])) {
                temp = map.get(s[i]);
                temp.offer(i);
            } else {
                temp = new LinkedList<>();
                temp.offer(i);
                map.put(s[i], temp);
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] != 1) {
                if (map.containsKey(g[i])) {
                    temp = map.get(g[i]);
                    if (!temp.isEmpty()) {
                        cow++;
                        temp.poll();
                    }

                }
            }
        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        new BullsandCows_299().getHint("1123", "0111");
    }
}
