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
    private static int result = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        solver(root);
        int ans = result - 1;
        result = Integer.MIN_VALUE;
        return ans;
    }

    public static int solver(TreeNode root){
        if(root == null){
            result = Math.max(result, 0);
            return 0;
        }
        int left = solver(root.left);
        int right = solver(root.right);
        result = Math.max(result, left+right+1);
        return Math.max(left,right)+1;
    }
}
