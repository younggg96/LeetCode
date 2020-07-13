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

public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void helper(TreeNode root, StringBuilder res) {
        if(root == null) return;
        res.append(root.val).append(",");
        helper(root.left, res);
        helper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        return build(arr, 0, arr.length - 1);
    }

    private TreeNode build(String[] arr, int lo, int hi) {
        if(lo > hi) return null;
        TreeNode root = new TreeNode(Integer.valueOf(arr[lo]));
        int index = hi + 1;
        for(int i = lo + 1; i < hi; i++) {
            if(Integer.valueOf(arr[i]) > root.val) {
                index = i;
                break;
            }
        }
        root.left = build(arr, lo + 1, index -1);
        root.right = build(arr, index, hi);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));