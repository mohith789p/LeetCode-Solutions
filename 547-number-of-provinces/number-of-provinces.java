class Solution {
    private int count = 0;
    private int n;
    private void bfs(int s, boolean[] vis, int[][] am){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i = 0; i < n; i++){
                if(!vis[i] && am[cur][i] == 1) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }

    private void countBfs(int[][] am){
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                bfs(i, vis, am);
                count++;
            }
        }
    }
    public int findCircleNum(int[][] am) {
        this.n = am.length;
        countBfs(am);
        return count;
    }
}