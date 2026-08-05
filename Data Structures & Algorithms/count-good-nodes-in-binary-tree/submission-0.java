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
    public int goodNodes(TreeNode root) {
        return solver(root, -101);
    }
    public static int solver(TreeNode root, int maxVal){
        if(root == null)return  0;
        int val = 0;
        if(root.val >= maxVal){
            val ++;
            maxVal = root.val;
        }
        val += solver(root.left, maxVal);
        val += solver(root.right, maxVal);
        return val;
    }
}
