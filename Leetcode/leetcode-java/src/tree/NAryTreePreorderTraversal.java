package tree;

import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        return dfs(list, root);
    }
    
    private List<Integer> dfs(List<Integer> list, Node node) {
        if(node != null) {
            list.add(node.val);
            if(node.children != null) {
                for(Node child: node.children) {
                    dfs(list, child);
                }
            }
        }
        return list;
    }
}