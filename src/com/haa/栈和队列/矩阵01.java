package com.haa.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 矩阵01 {
    /*
    给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

    两个相邻元素间的距离为 1 。
    输入：
    [[0,0,0],
    [0,1,0],
    [0,0,0]]

    输出：
    [[0,0,0],
     [0,1,0],
     [0,0,0]]
     */
    /*
    分析：因为要找最近的，广度优先搜索比深度优先搜索更有优势，所以这里采用广度优先搜索
    注意：1.只有是1的需要计算，0的距离就是零，所以在入队时只用把0入队，来检索1
         2.把原来是1的变为-1，因为如果不变不能说明是之前访问过的1还是访问后就是1
    时间复杂度O(N*M)
    空间复杂度O(N*M)
     */
    public int[][] updateMatrix(int[][] matrix) {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return matrix;
    }





}
