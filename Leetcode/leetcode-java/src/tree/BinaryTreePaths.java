package tree;

import java.util.ArrayList;

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
class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> arr = new ArrayList<String>();
        helper(root, "", arr);
        return arr;
        
    }

    public void helper(TreeNode root, String path, ArrayList<String> arr ) {
        if(root == null) return;
        path += Integer.toString(root.val);
        if(root.left == null && root.right == null) {
            arr.add(path);
        } else {
            path += "->";
            helper(root.left, path, arr);
            helper(root.right, path, arr);
        }
        
    }
}