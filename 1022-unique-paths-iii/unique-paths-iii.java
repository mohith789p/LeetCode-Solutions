class Solution {
    private int count;
    private int valid;
    public int uniquePathsIII(int[][] grid) {
        count = 0;
        valid = 0;
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

        dfs(grid, starti, startj);

        return count;
    }

    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1) return;
        
        if(grid[i][j] == 2){
            if(valid == -1){
                count++;
            }
            return;
        }

        grid[i][j] = -1;
        valid--;

        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);

        grid[i][j] = 0;
        valid++;
    }
}