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
    public List<Integer> rightSideView(TreeNode root) {
        TreeNode curr = root;
        List<Integer>result = new ArrayList<>();
        Queue<TreeNode>q = new ArrayDeque<>();
        if (root == null)return result;
        q.offer(root);
        while(!q.isEmpty()){
            int counter = q.size();
            while(counter-- > 0){
                curr = q.poll();
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            result.add(curr.val);
        }
        return result;
    }
}
