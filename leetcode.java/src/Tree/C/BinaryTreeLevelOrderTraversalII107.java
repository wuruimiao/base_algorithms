package Tree.C;

import Struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* 107. 二叉树的层次遍历 II
* 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class BinaryTreeLevelOrderTraversalII107 {
    private static void postOrderTraversal(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left, res, level + 1);
        postOrderTraversal(node.right, res, level + 1);
        while (level >= res.size()) {
            res.add(0, new ArrayList<>());
        }
        System.out.print(level + " ");
        System.out.println(Arrays.toString(res.toArray()));
        res.get(res.size()-level - 1).add(node.val);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        postOrderTraversal(root, res, 0);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> result = levelOrderBottom(root);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
