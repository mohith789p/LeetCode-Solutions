/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node[] vis = new Node[101];

    public Node cloneGraph(Node node) {
        if(node == null) return node;

        if(vis[node.val] != null){
            return vis[node.val];
        }

        Node clone = new Node(node.val);
       vis[node.val] = clone;

        for(Node neigh : node.neighbors){
            clone.neighbors.add(cloneGraph(neigh));
        }

        return clone;
    }
}