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
    public boolean isValidBST(TreeNode root) {
        return solver(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean solver(TreeNode root, int leftVal, int rightVal){
        if(root == null)return true;
        if(root.val <= leftVal || root.val >= rightVal)return false;
        return solver(root.left, leftVal, root.val) && solver(root.right, root.val, rightVal);
    }
}
