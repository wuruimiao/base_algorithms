package Tree;

/*
* 671. 二叉树中第二小的节点
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

示例 1:

输入:
    2
   / \
  2   5
     / \
    5   7

输出: 5
说明: 最小的值是 2 ，第二小的值是 5 。
示例 2:

输入:
    2
   / \
  2   2

输出: -1
说明: 最小的值是 2, 但是不存在第二小的值。
* */

import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SecondMinimumNodeInABinaryTree671 {
    private int bfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int min = root.val;
        int target = -1;
        boolean has = false;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                if (node.left.val == min) {
                    q.add(node.left);
                } else {
                    if (has) {
                        target = Math.min(node.left.val, target);
                    } else {
                        target = node.left.val;
                        has = true;
                    }
                }
            }
            if (node.right != null) {
                if (node.right.val == min) {
                    q.add(node.right);
                } else {
                    if (has) {
                        target = Math.min(node.right.val, target);
                    } else {
                        target = node.right.val;
                        has = true;
                    }
                }
            }
        }
        return target;
    }

    private int dfs(TreeNode node, int min) {
        if (node == null) return -1;
        if (node.val > min) {
            return node.val;
        }
        int l = dfs(node.left, min);
        int r = dfs(node.right, min);
        if (l == -1) return r;
        if (r == -1) return l;
        return Math.min(l, r);
    }

    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, root.val);
    }
}
