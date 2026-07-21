class Solution {
    private int count;
    private int valid;
    public int uniquePathsIII(int[][] grid) {
        count = 0;
        valid = 1;
        int starti = 0, startj = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    valid++;
                }
                if(grid[i][j] == 1){
                    starti = i;
                    startj = j;
                }
            }
        }

        dfs(grid, starti, startj, new ArrayList<>());

        return count;
    }

    private void dfs(int[][] grid, int i, int j, List<int[]> ans){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) return;
        
        if(grid[i][j] == 2){
            if(ans.size() == valid){
                count++;
            }
            return;
        }

        grid[i][j] = -1;
        ans.add(new int[]{i, j});

        dfs(grid, i - 1, j, ans);
        dfs(grid, i, j + 1, ans);
        dfs(grid, i + 1, j, ans);
        dfs(grid, i, j - 1, ans);

        grid[i][j] = 0;
        ans.remove(ans.size() - 1);
    }
}