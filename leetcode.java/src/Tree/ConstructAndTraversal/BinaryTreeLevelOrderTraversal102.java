package Tree.ConstructAndTraversal;


/*
* 102. 二叉树的层序遍历
* 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

import Struct.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal102 {
    private void traversal(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        while (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        traversal(node.left, level + 1, result);
        traversal(node.right, level + 1, result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, 0, result);
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> items = new ArrayList<>();
            // 注意这里
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                items.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(items);
        }

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
        List<List<Integer>> result = new BinaryTreeLevelOrderTraversal102().levelOrder2(root);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
