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
            dfs(heights, 0, col, m, n, heights[0][col], pac);
            dfs(heights, m - 1, col, m, n, heights[m - 1][col], atl);
        }

        for (int row = 0; row < m; row++) {
            dfs(heights, row, 0, m, n, heights[row][0], pac);
            dfs(heights, row, n - 1, m, n, heights[row][n - 1], atl);
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

    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] grid, int row, int col, int m, int n, int prev, boolean[][] vis) {
        if (row < 0 || col < 0 || row >= m || col >= n || vis[row][col] || grid[row][col] < prev) return;

        vis[row][col] = true;

        for(int[] d : dir) dfs(grid, row + d[0], col + d[1], m, n, grid[row][col], vis);
    }
}