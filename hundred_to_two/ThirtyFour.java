package LeetCode.hundred_to_two;

public class ThirtyFour {

    /**
     * My approach.
     *  Time limit exceed.
     */
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {  // starting from station i
            if (gas[i] < cost[i]) {
                continue;
            }

            boolean can = true;
            int remain = 0;
            for (int j = i, k = 0; k < gas.length; j = (j + 1) % gas.length, k++) {
                remain = gas[j] - cost[j] + remain;
                if (remain < 0) {
                    can = false;
                    break;
                }
            }

            if (can) {
                return i;
            }
        }

        return  -1;
    }

    /**
     *  If car starts at A and can not reach B. Any station between A and B
     *  can not reach B.(B is the first station that A can not reach.)
     *  If the total number of gas is bigger than the total number of cost. There must be a solution.
     *  (Should I prove them?)
     */
    private static int canComplete(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int remain = gas[start] - cost[start];
        while (start > end) {
            if (remain >=0 ) {
                remain = gas[end] - cost[end] + remain;
                end++;
            } else {
                start--;
                remain = remain + gas[start] - cost[start];
            }
        }

        return remain >=0 ? start : -1;
    }

    public static void main(String[] args) {
        //System.out.println(canCompleteCircuit(new int[]{1, 3, 4}, new int[]{2, 5, 3}));
        //System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{6, 5, 6}));
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 3}, new int[]{2, 1, 5, 1}));
    }
}
