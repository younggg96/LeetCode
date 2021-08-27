package dp;

import java.util.HashMap;

// 337. House Robber III
// Medium

// 3000

// 58

// Add to List

// Share
// The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

// Determine the maximum amount of money the thief can rob tonight without alerting the police.

// Example 1:

// Input: [3,2,3,null,3,null,1]

//      3
//     / \
//    2   3
//     \   \ 
//      3   1

// Output: 7 
// Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
// Example 2:

// Input: [3,4,5,1,3,null,1]

//      3
//     / \
//    4   5
//   / \   \ 
//  1   3   1

// Output: 9
// Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
// Accepted
// 167,926
// Submissions
// 330,490


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class HouseRobber3 {
    HashMap<TreeNode, Integer> doRob = new HashMap<TreeNode, Integer>();
    HashMap<TreeNode, Integer> notRob = new HashMap<TreeNode, Integer>();
    public int rob(TreeNode root) {
        helper(root);
        return Math.max(doRob.getOrDefault(root, 0), notRob.getOrDefault(root, 0));
        
    }
    
    private void helper(TreeNode node) {
        if(node == null) return;
        helper(node.left);
        helper(node.right);
        doRob.put(node, node.val + notRob.getOrDefault(node.left, 0) + notRob.getOrDefault(node.right, 0));
        notRob.put(node, Math.max(doRob.getOrDefault(node.left, 0), notRob.getOrDefault(node.left, 0)) + Math.max(doRob.getOrDefault(node.right, 0), notRob.getOrDefault(node.right, 0)));
    }
}
