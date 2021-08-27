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
class Solution {
    public ArrayList<Integer> helper(TreeNode r, ArrayList<Integer> arr) {
        if(r == null) return arr;
        helper(r.left, arr);
        arr.add(r.val);
        helper(r.right, arr);
        return arr;
    }


    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        helper(root, arr);


        return arr.get(k -);
    }
}