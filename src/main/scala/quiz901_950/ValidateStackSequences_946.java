package quiz901_950;

import java.util.Stack;

/**
 * Created by john_liu on 2019/4/14.
 */
public class ValidateStackSequences_946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < pushed.length) {
            if (stack.isEmpty()) stack.push(pushed[pushIndex++]);
            if (popIndex < popped.length && stack.peek() == popped[popIndex]) {
                popIndex++;
                stack.pop();
            } else stack.push(pushed[pushIndex++]);
        }
        while (popIndex < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[popIndex]) return false;
            popIndex++;
            stack.pop();

        }

        return popIndex >= popped.length;
    }
}
