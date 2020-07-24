package tree;

import java.util.LinkedList;
import java.util.Queue;

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

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int target = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.right != null) {
                queue.add(node.right);
                target = node.right.val;
            }
            if(node.left != null) {
                queue.add(node.left);
                target = node.left.val;
            }
        }

        return target;

    }
}