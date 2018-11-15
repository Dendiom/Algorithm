package LeetCode.three_hundred_to_four;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SeventyEight {

    /**
     * from discussion, use PriorityQueue(heap sort)
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (k == n * n) {
            return matrix[n - 1][n - 1];
        }

        PriorityQueue<Point> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.offer(new Point(i, 0, matrix[i][0]));
        }

        while (k > 1) {
            k--;
            Point point = heap.poll();
            if (point.getY() < n - 1) {
                heap.offer(new Point(point.getX(), point.getY() + 1, matrix[point.getX()][point.getY() + 1]));
            }
        }

        return heap.peek().getVal();
    }

    class Point implements Comparable<Point>{

        private int x;
        private int y;
        private int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return val - o.val;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}
