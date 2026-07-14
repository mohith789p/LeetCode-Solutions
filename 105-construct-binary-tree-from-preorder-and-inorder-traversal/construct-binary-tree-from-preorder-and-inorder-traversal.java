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
    private Map<Integer, Integer> mp;
    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        mp = new HashMap<>();

        for(int i = 0; i < preorder.length; i++){
            mp.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end) {
        if(start > end){
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIdx++]);
        int idx = mp.get(node.val);

        node.left = build(preorder, start, idx - 1);
        node.right = build(preorder, idx + 1, end);

        return node;
    }
}