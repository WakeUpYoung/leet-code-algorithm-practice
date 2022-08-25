package com.wakeupyoung.graph;

import com.wakeupyoung.Solution;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/max-area-of-island">URL</a>
 */
public class MaxAreaOfIsland implements Solution<Integer, Input> {

    public static void main(String[] args) {
        Input input = new Input();
//        input.grid = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        input.grid = new int[][]{{1}};
        Integer resolve = new MaxAreaOfIsland().resolve(input);
        System.out.println(resolve);
    }

    @Override
    public Integer resolve(Input input) {
        int[][] grid = input.grid;
        int maxArea = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int result = dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + 1;
        System.out.println("dfs: " + result);
        return result;
    }
}

class Input {
    int[][] grid;
}
