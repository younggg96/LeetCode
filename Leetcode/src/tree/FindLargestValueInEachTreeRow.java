package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// You need to find the largest value in each row of a binary tree.

// Example:
// Input: 

//           1
//          / \
//         3   2
//        / \   \  
//       5   3   9 

// Output: [1, 3, 9]

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int count = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i= 0; i < count; i++ ) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                } 
            }
            ans.add(max);
        }
        return ans;
        
    }
}