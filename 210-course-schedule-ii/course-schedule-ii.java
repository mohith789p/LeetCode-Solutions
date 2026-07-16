class Graph {
    List<List<Integer>> adj = new ArrayList<>();

    Graph(int n) {
        while (n-- != 0) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    List<Integer> getNeigh(int curr) {
        return adj.get(curr);
    }
}

class Solution {
    public int[] findOrder(int n, int[][] edges) {
        int[] indeg = new int[n];
        Graph gh = new Graph(n);

        for (int[] edge : edges) {
            indeg[edge[0]]++;
            gh.addEdge(edge[1], edge[0]);
        }

        int idx = 0;
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            ans[idx++] = cur;
            for (int neigh : gh.getNeigh(cur)) {
                if (--indeg[neigh] == 0)
                    q.add(neigh);
            }
        }
        
        return idx != n ? new int[0] : ans;
    }
}