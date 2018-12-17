package quiz401_450;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by john_liu on 2018/12/15.
 */
public class RemoveKDigits_402 {
    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new LinkedList<>();
        char[] nums = num.toCharArray();
        for (int i = 0; i < num.length(); i++) {
            int curr = Integer.parseInt(String.valueOf(nums[i]));
            if (stack.isEmpty()) stack.push(curr);
            else if (k == 0) stack.push(curr);
            else {
                while(!stack.isEmpty() && stack.peek() > curr && k > 0) {stack.pop(); k--;}
                stack.push(curr);
            }
        }

        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder re = new StringBuilder();
        while(!stack.isEmpty()){
            int temp  = stack.pollLast();
            if(temp == 0) continue ;
            else re.append(temp);
            break;
        }
        while(!stack.isEmpty()){
            int temp  = stack.pollLast();
            re.append(temp);
        }
        if(re.length() ==0)re.append(0);
        return re.toString();
    }
}
