package Tree.ConstructAndTraversal;

import Struct.Node;

import java.util.*;

/*
* 589. N叉树的前序遍历
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

返回其前序遍历: [1,3,5,6,2,4]。



说明: 递归法很简单，你可以使用迭代法完成此题吗?
* */
public class NAryTreePreorderTraversal589 {
    private void dfs(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        for (Node child: node.children) {
            dfs(child, result);
        }
    }

    private List<Integer> bfs(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            result.add(node.val);
            for (int i = node.children.size()-1; i >= 0; i--) {
                stack.addLast(node.children.get(i));
            }
        }
        return result;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }
}
