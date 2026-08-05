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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>>result = new ArrayList<>();
        if(root == null)return result;
        q.offer(root);
        while(!q.isEmpty()){
            int counter = q.size();
            List<Integer>innerList = new ArrayList<>();
            System.out.println(counter);
            while (counter-- > 0){
                TreeNode curr = q.poll();
                innerList.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            result.add(innerList);
        }
        return result;
    }
}
