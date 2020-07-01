package Tree.ConstructAndTraversal;

/*
* 144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
* */

import Struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        dfs(node.left, result);
        dfs(node.right, result);
    }

    private List<Integer> bfs(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.add(node.val);
            if (node.right != null) stack.addLast(node.right);
            if (node.left != null) stack.addLast(node.left);
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }
}
