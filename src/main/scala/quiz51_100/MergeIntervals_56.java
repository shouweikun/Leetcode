package quiz51_100;


import Context.java.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by john_liu on 2019/4/8.
 */
public class MergeIntervals_56 {


    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        intervals = new ArrayList<>(intervals);
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> re = new LinkedList<>();
        int left = 0;
        int right = 1;
        while (right < intervals.size()) {
            Interval curr = intervals.get(right);
            Interval head = intervals.get(left);
            if (curr.start >= head.start && curr.start <= head.end) {
                head.end = Math.max(head.end, curr.end);
                head.start = Math.min(head.start, curr.start);
            } else {
                re.add(head);
                left = right;
            }
            if (right == intervals.size() - 1) re.add(intervals.get(left));
            right++;
        }
        return re;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1, 4);
        Interval i2 = new Interval(0, 4);
        List<Interval> list = new ArrayList<>(2);
        list.add(i1);
        list.add(i2);
        new MergeIntervals_56().merge(list);
    }
}
