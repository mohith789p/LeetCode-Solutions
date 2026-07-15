
class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) q.add(new int[] {i, j});
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- != 0){
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];

                if(i - 1 >= 0 && j >= 0 && i - 1 < grid.length && j < grid[0].length && grid[i- 1][j] == 1){
                    q.add(new int[] {i - 1, j});
                    grid[i - 1][j] = grid[i][j] + 1;
                }
                if(i >= 0 && j + 1 >= 0 && i < grid.length && j + 1 < grid[0].length && grid[i][j + 1] == 1){
                    q.add(new int[] {i, j + 1});
                    grid[i][j + 1] = grid[i][j] + 1;
                }
                if(i + 1 >= 0 && j >= 0 && i + 1 < grid.length && j < grid[0].length && grid[i+ 1][j] == 1){
                    q.add(new int[] {i + 1, j});
                    grid[i + 1][j] = grid[i][j] + 1;
                }
                if(i >= 0 && j - 1 >= 0 && i < grid.length && j - 1 < grid[0].length && grid[i][j - 1] == 1){
                    q.add(new int[] {i, j - 1});
                    grid[i][j - 1] = grid[i][j] + 1;
                }
            }
        }
        
        int max = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
                max = Math.max(max, grid[i][j]);
            }
        }

        return max < 2 ? 0 : max - 2;
    }
}