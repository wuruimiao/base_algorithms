package Tree.Path;

import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/*
* 257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
* */
public class BinaryTreePaths257 {
    private void dfs(TreeNode node, List<String> results, String res) {
        if (node != null) {
            res += node.val;
            if (node.left == null && node.right == null) {
                results.add(res);
                return;
            }
            if (node.left != null) {
                dfs(node.left, results, res + "->");
            }
            if (node.right != null) {
                dfs(node.right, results, res + "->");
            }
        }
    }

    private List<String> bfs(TreeNode root) {
        Queue<TreeNode> qNode = new ArrayDeque<>();
        Queue<String> qStr = new ArrayDeque<>();
        if (root != null) {
            qNode.add(root);
            qStr.add(Integer.toString(root.val));
        }
        List<String> result = new ArrayList<>();
        while (!qNode.isEmpty()) {
            TreeNode node = qNode.poll();
            String str = qStr.poll();
            if (node.left == null && node.right == null) {
                result.add(str);
                continue;
            }
            if (node.left != null) {
                qNode.add(node.left);
                qStr.add(str + "->" + node.left.val);
            }
            if (node.right != null) {
                qNode.add(node.right);
                qStr.add(str + "->" + node.right.val);
            }
        }
        return result;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, "");
        return result;
    }
}
