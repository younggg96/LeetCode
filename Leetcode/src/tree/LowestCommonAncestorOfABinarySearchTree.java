package tree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        if(root.val > pVal && root.val > qVal) return lowestCommonAncestor(root.left, p, q);
        if(root.val < pVal && root.val < qVal) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}