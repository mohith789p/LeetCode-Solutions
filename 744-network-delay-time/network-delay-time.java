class Graph {
    int n;
    List<List<int[]>> al;

    Graph(int n) {
        this.n = n;
        al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
    }

    void addEdge(int[] edge) {
        // edge = {u, v, w}
        al.get(edge[0] - 1).add(new int[]{edge[1] - 1, edge[2]});
    }

    int findDelay(int s) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s - 1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{s - 1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];

            if (d > dist[u]) continue;

            for (int[] adj : al.get(u)) {
                int v = adj[0], w = adj[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        int max = 0;
        for (int d : dist) {
            if (d == Integer.MAX_VALUE) return -1; // unreachable node
            max = Math.max(max, d);
        }
        return max;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Graph gh = new Graph(n);
        for (int[] time : times) {
            gh.addEdge(time);
        }
        return gh.findDelay(k);
    }
}
