package quiz151_200;

/**
 * Created by john_liu on 2018/12/5.
 */
public class TwoSum2_Input_array_is_sorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum;
        while (left != numbers.length - 2) {
            sum = numbers[left]+numbers[right];
            if(sum==target) break;
            if(right-left ==1){
                left++;
                right = numbers.length-1;
                continue;
            }
            if(sum>target) right--;
            if(sum<target) left++;
        }
        int[] re = {left+1,right+1};
        return  re;
    }
}
