package LeetCode.two_hundred_to_three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Fifteen {

    /**
     * Approach 1:
     *  Sort Array first  O(NlogN) + O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * Approach 3:
     *  Priority Queue, it's an implementation of heap sort.Default is small heap.
     */
    public int findKthLargestThree(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}
