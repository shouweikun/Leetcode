package quiz51_100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by john_liu on 2019/4/10.
 */
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        if (path.length() <= 1) return path;
        char[] chars = path.toCharArray();
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i <= chars.length; i++) {
            char c = i == chars.length ? '/' : chars[i];
            if (stack.isEmpty() || isvaild(c) || c == '.') {
                stack.push(c);
                continue;
            }
            if (c == '/') {
                if (stack.peek() == '/') continue;
                if (stack.peek() == '.') {
                    int count = 0;
                    while (!stack.isEmpty() && stack.peek() == '.') {
                        stack.pop();
                        count++;
                    }
                    if (count == 2) {
                        if (!stack.isEmpty() && stack.peek() == '/') stack.pop();

                        while (!stack.isEmpty() && stack.peek() != '/') {
                            stack.pop();
                        }
                    } else if(count>=3){
                        for(int j = 1;j<=count;j++){
                            stack.push('.');
                        }
                    }
                }
                if (!stack.isEmpty() && isvaild(stack.peek())) {
                    stack.push(c);
                }
            }
        }
        if (stack.isEmpty()) return "/";
        if (stack.size() > 1 && stack.peek() == '/') stack.pop();
        if (!stack.isEmpty() && stack.peekLast() != '/') stack.addLast('/');
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    private boolean isvaild(char c) {
        return c !='/' && c!='.';
    }

    public static void main(String[] args) {
        String str1 = "/home";
        String re = new SimplifyPath_71().simplifyPath(str1);
        System.out.println(re);
    }
}
