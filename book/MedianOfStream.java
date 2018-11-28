package LeetCode.book;

import java.util.PriorityQueue;

/**
 * 从数据流中获取中位数
 */
public class MedianOfStream {

    /**
     * 使用两个堆，小的数放在大根堆，大的数放在小根堆，这样取堆顶数就可以计算出中位数
     */

    private int count = 0;  // 总的数字数目
    private PriorityQueue<Integer> small = new PriorityQueue<>((o1, o2) -> o2 - o1); // 大根堆存储较小数据
    private PriorityQueue<Integer> big = new PriorityQueue<>(); // 小根堆存储较大数据

    public void insert(Integer val) {
        count++;
        if (count % 2 != 0) {  // 第奇数个数放左边，偶数个数放右边
            big.add(val);
            small.add(big.poll());
        } else {
            small.add(val);
            big.add(small.poll());
        }
    }

    public Double getMedian() {
        return count % 2 == 0 ? (small.peek() + big.peek()) / 2.0: (double)small.peek();
    }
}
