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

public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        return dfs(list, root);
    }
    
    private List<Integer> dfs(List<Integer> list, Node node) {
        if(node != null) {
            if(node.children != null) {
                for(Node child: node.children) {
                    dfs(list, child);
                }
            }
            list.add(node.val);
        }
        return list;
    }
}