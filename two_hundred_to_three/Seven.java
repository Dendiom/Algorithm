package LeetCode.two_hundred_to_three;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Seven {


    /**
     * DFS. 10ms
     */
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] visit = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (DFS(graph, i, visit)) {
                return false;
            }
        }

        return true;
    }

    private static boolean DFS(List<Integer>[] graph, int vertex, int[] visit) {
        // 1 is visiting
        // 2 is visited
        // 0 is unvisited
        // better than boolean[] visit, it can return directly when visit == 2
        if (visit[vertex] == 1) {
            return true;
        }

        if (visit[vertex] == 2) {
            return false;
        }

        visit[vertex] = 1;
        for (int adjoin : graph[vertex]) {
            if (DFS(graph, adjoin, visit)) {
                return true;
            }
        }

        visit[vertex] = 2;  // very important
        return false;
    }


    /**
     * BFS. 13ms
     */
    private static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        int[] indgree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            indgree[edge[0]]++;
        }

        Queue<Integer> vertexs = new LinkedList<>();
        for (int i = 0; i < indgree.length; i++) {
            if (indgree[i] == 0) {
                vertexs.offer(i);
            }
        }

        int count = 0;
        while (!vertexs.isEmpty()) {
            int poll = vertexs.poll();
            count++;

            for (int adjoin: graph[poll]) {
               if (--indgree[adjoin] == 0) {
                   vertexs.offer(adjoin);
               }
            }
        }

        return  count == numCourses;
    }


    public static void main(String[] args) {
        System.out.println(canFinish(3, new int[][]{{1, 0}, {2, 1}, {1, 2}}));
    }
}
