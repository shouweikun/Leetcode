package quiz151_200;

import java.util.Stack;

/**
 * Created by john_liu on 2019/4/9.
 */
public class minStack_155 {
    class MinStack {
        private Stack<Integer> minStack = new Stack<>();
        private Stack<Integer> stack = new Stack<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) minStack.push(x);
            else if (minStack.peek() >= x) minStack.push(x);
        }

        public void pop() {
            int x = stack.pop();
            if (!minStack.isEmpty() && minStack.peek() == x) minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
