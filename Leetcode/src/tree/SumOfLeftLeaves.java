package tree;
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
class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return sum;
        helper(root, false);
        return sum;
    }
    
    private void helper(TreeNode root, boolean flag) {
        if(root == null) return;
        if(flag && root.left == null && root.right == null) {
            sum += root.val;
        } else {
            helper(root.left, true);
            helper(root.right, false);
        }


    }
}