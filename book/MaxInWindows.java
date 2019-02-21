package LeetCode.book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，
 * 他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 */
public class MaxInWindows {

    /**
     * 维护一个大根堆即可
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }

        if (size < 1 || size > num.length) {
            return result;
        }

        // 默认构造函数是小根堆，大根堆需要传入比较器
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < size; i++) {
            heap.add(num[i]);
        }

        result.add(heap.peek());
        for (int i = size, j = 0; i < num.length; i++, j++) {
            heap.remove(num[j]);
            heap.add(num[i]);
            result.add(heap.peek());
        }

        return result;
    }
}
