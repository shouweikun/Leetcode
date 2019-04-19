package quiz401_450;

import java.util.*;

/**
 * Created by john_liu on 2019/4/13.
 */
public class FindAllNumbersDisappearedinanArray_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length <= 1) return Collections.emptyList();
        LinkedList<Integer> re = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int index = nums[i] - 1;
            while (nums[index] != 0) {
                nums[i] = nums[index];
                nums[index] = 0;
                index = nums[i] - 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) re.add(i + 1);
        }

        return re;
    }

    private void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}

