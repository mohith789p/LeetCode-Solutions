import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return ans;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int col = 0; col < n; col++) {
            dfs(heights, 0, col, heights[0][col], pac);
            dfs(heights, m - 1, col, heights[m - 1][col], atl);
        }

        for (int row = 0; row < m; row++) {
            dfs(heights, row, 0, heights[row][0], pac);
            dfs(heights, row, n - 1, heights[row][n - 1], atl);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pac[r][c] && atl[r][c]) {
                    ans.add(Arrays.asList(r, c));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int row, int col, int prev, boolean[][] vis) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] || grid[row][col] < prev) {
            return;
        }

        vis[row][col] = true;

        dfs(grid, row - 1, col, grid[row][col], vis);
        dfs(grid, row + 1, col, grid[row][col], vis);
        dfs(grid, row, col - 1, grid[row][col], vis);
        dfs(grid, row, col + 1, grid[row][col], vis);
    }
}