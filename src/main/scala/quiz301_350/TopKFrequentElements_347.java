package quiz301_350;

import java.util.*;


/**
 * Created by john_liu on 2018/12/4.
 */
public class TopKFrequentElements_347 {
    class Pair {
        public int value;
        public int fre;

        public Pair(int value, int fre) {
            this.value = value;
            this.fre = fre;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) return Collections.emptyList();
        Arrays.sort(nums);
        List<Pair> list = new LinkedList<>();
        ListIterator<Pair> iter;
        int count = 1;
        int last = nums[0];
        if (nums.length == 1) list.add(new Pair(last, count));
        for (int i = 1; i <= nums.length; i++) {

            if (i < nums.length && last == nums[i]) count++;
            else {
                if (list.isEmpty()) list.add(new Pair(last, count));
                else {
                    iter = list.listIterator();
                    while (iter.hasNext()) {
                        if (iter.next().fre < count) {
                            iter.previous();
                            iter.add(new Pair(last, count));
                            break;
                        } else if (!iter.hasNext()) {
                            list.add(new Pair(last, count));
                            break;
                        }

                    }
                    if (list.size() > k) list.remove(k);

                }
                count = 1;
                last = nums[i];
            }
        }


        List<Integer> re = new LinkedList<>();
        iter = list.listIterator();
        while (iter.hasNext()) {
            re.add(iter.next().value);
        }
        return re;

    }

    public List<Integer> topKMin(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length == 0) return Collections.emptyList();
        makeHeap(nums);
        List<Integer> re = new LinkedList<>();
        int last = nums[0];
        re.add(nums[0]);
        int count = 1;
        int i = 1;
        while (count < k) {
            adjustHeap(nums, i, nums.length - 1);
            if (last != nums[i]) {
                count++;
                re.add(nums[i]);
            }
            i++;
        }
        return re;
    }

    private void makeHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
    }

    private void adjustHeap(int[] nums, int start, int end) {
        int temp = nums[start];
        for (int i = start * 2; i <= end; i *= 2) {
            if (i < end && nums[i] > nums[i + 1]) i++;
            if (temp <= nums[i]) break;
            nums[start] = nums[i];
            start = i;
        }
        nums[start] = temp;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {-1, -1};
        List<Integer> a = new TopKFrequentElements_347().topKFrequent(nums, 2);
        a.toString();
    }


}
