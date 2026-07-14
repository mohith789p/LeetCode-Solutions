/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int max = 0;
    private List<Integer> firstIdx;

    public int widthOfBinaryTree(TreeNode root) {
        firstIdx = new ArrayList<>();
        dfs(root, 0, 0);
        return max;
    }

    private void dfs(TreeNode root, int depth, int idx){
        if(root == null) return;

        if(depth == firstIdx.size()){
            firstIdx.add(idx);
        }

        int width = idx - firstIdx.get(depth) + 1;
        max = Math.max(width, max);
        dfs(root.left, depth + 1, 2 * idx + 1);
        dfs(root.right, depth + 1, 2 * idx + 2);
    }
}