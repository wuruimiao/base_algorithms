package Tree.Path;

import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 404. 左叶子之和
计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
* */
public class SumOfLeftLeaves404 {
    private int dfs(TreeNode node, boolean isLeft, int sum) {
        if (node == null) {
            return sum;
        }
        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
        }
        sum = dfs(node.left, true, sum);
        sum = dfs(node.right ,false, sum);
        return sum;
    }

    private int bfs(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<Boolean> qF = new ArrayDeque<>();
        if (root != null) {
            q.add(root);
            qF.add(false);
        }
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            boolean isLeft = qF.poll();
            if (isLeft && node.left == null && node.right == null) {
                sum += node.val;
            }
            if (node.left != null) {
                q.add(node.left);
                qF.add(true);
            }
            if (node.right != null) {
                q.add(node.right);
                qF.add(false);
            }
        }
        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {

        return dfs(root, false, 0);
    }
}
