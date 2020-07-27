package Hot100;

import Struct.TreeNode;
import Tree.ConstructAndTraversal.BinaryTreeLevelOrderTraversal102;

/*
* 538. 把二叉搜索树转换为累加树     https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。



例如：

输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
* */
public class ConvertBstToGreaterTree538 {
    private int sum = 0;

    private TreeNode convertBstCorrect(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    private int dfs(TreeNode node, int biggerSum) {
        if (node == null) return 0;
        int sum = 0;
        int rightSum = dfs(node.right, biggerSum);
        sum += rightSum;
        sum += dfs(node.left, biggerSum + node.val + rightSum);
        sum += node.val;

        node.val += biggerSum + rightSum;
        return sum;
    }


    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public static void main(String[] args) {
        ConvertBstToGreaterTree538 t = new ConvertBstToGreaterTree538();
        TreeNode root1 = new TreeNode(2,
                new TreeNode(0, new TreeNode(-4), new TreeNode(1)),
                new TreeNode(3));
        root1 = t.convertBST(root1);

        BinaryTreeLevelOrderTraversal102 tp = new BinaryTreeLevelOrderTraversal102();
        System.out.println(tp.levelOrder2(root1) + "==[5,6,3,2,6]");

    }
}
