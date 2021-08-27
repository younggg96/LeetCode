package tree;

import java.util.Arrays;


// 106. Construct Binary Tree from Inorder and Postorder Traversal
// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// For example, given

// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]
// Return the following binary tree:

//     3
//    / \
//   9  20
//     /  \
//    15   7


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

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        return helper(inorder, postorder);
    }
    
    private TreeNode helper(int in[], int[] post) {
        if(in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(post[post.length - 1]);
        for(int i = 0; i < in.length; ++i) {
            if(in[i] == post[post.length - 1]) {
                int[] inLeft = Arrays.copyOfRange(in, 0, i);
                int[] inRight = Arrays.copyOfRange(in, i + 1, in.length);
                int[] postLeft = Arrays.copyOfRange(post, 0, i);
                int[] postRight = Arrays.copyOfRange(post, i, post.length - 1);
                root.left = helper(inLeft, postLeft);
                root.right = helper(inRight, postRight);
                break;
            }
            
        }
        return root;
    }
}