package quiz101_150;

import java.util.*;

/**
 * Created by john_liu on 2019/4/21.
 *
 * @note 广度优先遍历   一定要把使用过的值错set中移除
 */
public class WordLadder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet();
        set.addAll(wordList);
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> lengthQueue = new LinkedList<>();
        queue.offer(beginWord);
        lengthQueue.offer(1);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int length = lengthQueue.poll();
            if (curr.intern() == endWord.intern()) {
                return length;
            }
            char[] chars = curr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (chars[i] == c) continue;
                    char tmp = chars[i];
                    chars[i] = c;
                    String newWord = new String(chars);
                    if (set.contains(newWord)) {
                        queue.offer(newWord);
                        lengthQueue.offer(length + 1);
                        set.remove(newWord);
                    }
                    chars[i] = tmp;
                }
            }
        }

        return 0;
    }
}
