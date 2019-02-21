package LeetCode.book;

import java.util.ArrayList;

/**
 * 和为 S 的连续正数序列
 */
public class FindContinuousSequence {

    // 记录下当前的和，可以去掉很多的重复计算
    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }

        int start = 1, end = 2, cur = 3;
        while (end <= sum / 2 + 1) {  // end不会超过和的一半加一
            if (cur < sum) {
                end++;
                cur += end;
            } else if (cur > sum) {
                cur -= start;
                start++;
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    temp.add(i);
                }
                result.add(temp);
                cur -= start;
                start++;
                end++;
                cur += end;
            }
        }

        return result;
    }
}
