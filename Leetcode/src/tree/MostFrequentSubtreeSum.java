package tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

public class MostFrequentSubtreeSum {
    HashMap<Integer,Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        findSum(root);
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i : map.keySet()){
            if(map.get(i) == max){
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i<result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public int findSum(TreeNode root){
        if(root == null){
            return 0;
        }
        //计算左子树的和
        int left = findSum(root.left);
        //计算右子树的和
        int right = findSum(root.right);
        //计算当前子树的和
        int sum = root.val + left + right;
        //将结果放入HashMap中，并计算出出现的最多次数
        map.put(sum,map.getOrDefault(sum,0)+1);
        max = Math.max(max,map.get(sum));
        return sum;
    }

}