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
    public int minDiffInBST(TreeNode root) {
        Queue<Integer> q = new LinkedList<>();
        inorder(root, q);
        if(q.isEmpty()) return 0;

        int prev = q.poll();
        int min = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            int ele = q.poll();
            min = Math.min(min, ele - prev);
            prev = ele;
        }

        return min;
    }

    private void inorder(TreeNode root, Queue<Integer> res){
        if(root == null) return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}