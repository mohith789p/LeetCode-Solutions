class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        List<List<Integer>> graph2 = new ArrayList<>();
        int[] outdeg = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph2.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int v : graph[i]) {
                graph2.get(v).add(i);
            }
            outdeg[i] = graph[i].length;
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (outdeg[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            vis[curr] = true;
            
            for (int neighbor : graph2.get(curr)) {
                if (--outdeg[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i]) {
                res.add(i);
            }
        }
        
        return res;
    }
}