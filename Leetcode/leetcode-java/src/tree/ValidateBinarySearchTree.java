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
class ValidateBinarySearchTree {
    public boolean helper(TreeNode r, Integer low, Integer high) {
        if(r == null) return true;
        int val = r.val;
        if(low != null && val <= low) return false;
        if(high != null && val >= high) return false;
        if(!helper(r.left, low, val)) return false;
        if(!helper(r.right, val, high)) return false;
        return true;
    }


    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}