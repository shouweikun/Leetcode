package quiz101_150;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john_liu on 2018/12/18.
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        List<List<Integer>> dp = new ArrayList<>(height);
        List<Integer> temp = new ArrayList<>(1);
        List<Integer> currDp;
        temp.add(triangle.get(0).get(0));
        dp.add(temp);
        for (int i = 1; i < height; i++) {
            temp = triangle.get(i);
            currDp = dp.get(0);
            List<Integer> nextDp = new ArrayList<>(temp.size());
            for (int j = 0; j < temp.size(); j++) {
                int prev = j - 1;
                int prevValue = (prev >= 0 && prev < currDp.size()) ? temp.get(j) + currDp.get(prev) : Integer.MAX_VALUE;
                int currValue = (j < currDp.size()) ? temp.get(j) + currDp.get(j) : Integer.MAX_VALUE;
                nextDp.add(j,Math.min(prevValue,currValue));
            }
            dp.add(0,nextDp);
        }

        int min = Integer.MAX_VALUE;
        for(int i :dp.get(0)){
           min =  Math.min(min,i);
        }
return min;
    }
}
