package LeetCode.book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class LeastKNumbers {

    /**
     * 使用一个大根堆，维护k个数，新数小于堆顶数时，删除堆顶，新数入堆
     */
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return new ArrayList<>();
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < input.length; i++) {
            heap.add(input[i]);
            if (heap.size() > k)
                heap.poll();
        }

        return new ArrayList<>(heap);
    }
}
