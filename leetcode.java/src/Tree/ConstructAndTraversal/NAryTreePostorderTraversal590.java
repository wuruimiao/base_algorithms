package Tree.ConstructAndTraversal;

import Struct.Node;

import java.util.*;

/*
* 590. N叉树的后序遍历
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :



返回其后序遍历: [5,6,3,2,4,1].



说明: 递归法很简单，你可以使用迭代法完成此题吗?
* */
public class NAryTreePostorderTraversal590 {
    private void dfs(Node node, List<Integer> result) {
        if (node == null) return;
        for (Node child : node.children) {
            dfs(child, result);
        }
        result.add(node.val);
    }

    private List<Integer> bfs(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.addFirst(node.val);
            stack.addAll(node.children);
        }
        return result;
    }

    public List<Integer> postorder(Node root) {
        return bfs(root);
    }
}
