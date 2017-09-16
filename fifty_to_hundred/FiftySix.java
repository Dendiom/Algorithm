package TestOne.fifty_to_hundred;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FiftySix {


    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2)
            return intervals;
        List<Interval> ans = new ArrayList<>();

        intervals.sort(new Comparator<Interval>() {          // sorted by start element, asc
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        ans.add(intervals.get(0));
        int lastIndex = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval pre = ans.get(lastIndex);
            Interval now = intervals.get(i);
            if (now.start > pre.end) {
                ans.add(now);
                lastIndex++;
            } else if (now.end > pre.end) {
                ans.add(new Interval(pre.start, now.end));
                ans.remove(lastIndex);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        List<Interval> test = new ArrayList<>();
        test.add(new Interval(1,3));
        test.add(new Interval(2,8));
        test.add(new Interval(4,9));
        System.out.println(merge(test));

    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }
}
