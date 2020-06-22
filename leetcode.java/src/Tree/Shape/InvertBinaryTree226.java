package Tree.Shape;


import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 226. 翻转二叉树
* 翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class InvertBinaryTree226 {
    private void bfs(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) {
            q.add(root);
        }
        TreeNode tmp;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    // 交换后再递归，是从上往下换
    // 递归后再交换，是从下往上换
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
    }

    public TreeNode invertTree(TreeNode root) {
        bfs(root);
        return root;
    }
}
