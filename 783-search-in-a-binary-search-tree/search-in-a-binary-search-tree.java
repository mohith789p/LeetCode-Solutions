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
    TreeNode node = null;
    public void search(TreeNode root, int val) {
        if(node != null || root == null) return;

        if(root.val == val){
            node = root;
        }

        if(root.val > val)
            search(root.left, val);

        search(root.right, val);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        search(root, val);
        return node;
    }
}