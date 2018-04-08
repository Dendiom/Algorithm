package LeetCode.two_hundred_to_three;


import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Zero {
    /**
     * My Approach.
     * Using BFS.
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        boolean[][] visit = new boolean[m][n];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    ans++;
                    queue.offer(new Pair<>(i, j));
                    visit[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> node = queue.poll();
                        int row = node.getKey();
                        int col = node.getValue();
                        if (col + 1 < n && grid[row][col + 1] == '1'
                                && !visit[row][col + 1]) {
                            queue.offer(new Pair<>(row, col + 1)); // right node
                            visit[row][col + 1] = true;
                        }

                        if (col - 1 >= 0 && grid[row][col - 1] == '1'
                                && !visit[row][col - 1]) {
                            queue.offer(new Pair<>(row, col - 1)); // left node
                            visit[row][col - 1] = true;
                        }

                        if (row + 1 < m && grid[row + 1][col] == '1'
                                && !visit[row + 1][col]) {
                            queue.offer(new Pair<>(row + 1, col));  // down node
                            visit[row + 1][col] = true;
                        }

                        if (row - 1 >= 0 && grid[row - 1][col] == '1'
                                && !visit[row - 1][col]) {
                            queue.offer(new Pair<>(row - 1, col));  // up node
                            visit[row - 1][col] = true;
                        }
                    }
                }
            }
        }

        return ans;
    }


    /**
     * Improve. Remove visit[][].
     */
    public int numIslandsTwo(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    queue.offer(new Pair<>(i, j));
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> node = queue.poll();
                        int row = node.getKey();
                        int col = node.getValue();
                        if (col + 1 < n && grid[row][col + 1] == '1') {
                            queue.offer(new Pair<>(row, col + 1)); // right node
                            grid[row][col + 1] = '0';
                        }

                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.offer(new Pair<>(row, col - 1)); // left node
                            grid[row][col - 1] = '0';
                        }

                        if (row + 1 < m && grid[row + 1][col] == '1') {
                            queue.offer(new Pair<>(row + 1, col));  // down node
                            grid[row + 1][col] = '0';
                        }

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.offer(new Pair<>(row - 1, col));  // up node
                            grid[row - 1][col] = '0';
                        }
                    }
                }
            }
        }

        return ans;
    }

    /**
     * DFS.
     */
    public int numIslandsDFS(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    DFS(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void DFS(char[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1
                || col < 0 || col > grid[0].length - 1
                || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        DFS(grid, row + 1, col);
        DFS(grid, row - 1, col);
        DFS(grid, row, col + 1);
        DFS(grid, row, col - 1);
    }
}
