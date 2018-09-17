package LeetCode.two_hundred_to_three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ten {


    // BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[] preCount = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            preCount[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (preCount[i] == 0) {
                ans[index++] = i;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int studied = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                int[] pair = prerequisites[i];
                if (studied == pair[1]) {
                    preCount[pair[0]]--;
                    if (preCount[pair[0]] == 0) {
                        ans[index++] = pair[0];
                        queue.offer(pair[0]);
                    }
                }
            }
        }

        return index == numCourses ? ans : new int[0];
    }
}
