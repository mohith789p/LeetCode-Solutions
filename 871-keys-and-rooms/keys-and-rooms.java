class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> al) {
        int n = al.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int count = 1;

        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int adj : al.get(cur)){
                if(!vis[adj]){
                    count++;
                    q.add(adj);
                    vis[adj] = true;
                }
            }
        }

        return count == n;
    }
}