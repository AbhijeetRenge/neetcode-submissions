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
    int cnt;
    public int kthSmallest(TreeNode root, int k) {
        this.cnt = 0; 
        return solver(root, k);
    }
    public int solver(TreeNode root, int k){
        // System.out.println(root.val+ " "+k+ " "+this.cnt);
        if(root.left != null){
            int val = solver(root.left, k);
            if(this.cnt == k)return val;
        }
        this.cnt++;
        if(this.cnt == k)return root.val;

        if(root.right != null){
            int val = solver(root.right, k);
            if(this.cnt == k) return val;
        }
        return root.val;
    }
}
