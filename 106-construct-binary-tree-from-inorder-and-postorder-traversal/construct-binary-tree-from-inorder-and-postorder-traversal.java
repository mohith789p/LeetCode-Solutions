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
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        mp = new HashMap<>();
        postIdx = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int start, int end){
        if(start > end) return null;

        TreeNode node = new TreeNode(postorder[postIdx--]);

        int idx = mp.get(node.val);

        node.right = build(postorder, idx + 1, end);
        node.left = build(postorder, start, idx - 1);

        return node;
    }
}