package quiz1_50;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2018/8/25.
 */
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> re = new LinkedList<>();
        backTracking(re,"",0,0,n);
        return re;
    }

    public void backTracking(List<String> ans,String cur,int left, int right,int max) {
        if(right==max) {
            ans.add(cur);
            return;
        }
        if(left<max) backTracking(ans,cur+"(",left+1,right,max);
        if(right<left) backTracking(ans,cur+")",left,right+1,max);
    }

}
