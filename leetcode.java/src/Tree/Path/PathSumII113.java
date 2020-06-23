package Tree.Path;

import Struct.TreeNode;

import java.util.*;

/*
* 113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
* */
public class PathSumII113 {
    private void dfs(TreeNode node, int target, List<List<Integer>> res, int sum, List<Integer> sol) {
        if (node == null) {
            return;
        }
        sum += node.val;
        sol.add(node.val);
        if (node.left == null && node.right == null) {
            if (target == sum) {
                res.add(new ArrayList<>(sol));
                sol.remove(sol.size() - 1);
                return;
            }
        }
        dfs(node.left, target, res, sum, sol);
        dfs(node.right, target, res, sum, sol);
        sol.remove(sol.size() - 1);
    }

    private List<List<Integer>> bfs(TreeNode root, int target) {
        Queue<TreeNode> qNode = new ArrayDeque<>();
        Queue<List<Integer>> qList = new ArrayDeque<>();
        Queue<Integer> qSum = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root != null) {
            qNode.add(root);
            qList.add(new ArrayList<>());
            qSum.add(0);
        }
        while (!qNode.isEmpty()) {
            TreeNode node = qNode.poll();
            List<Integer> list = new ArrayList<>(qList.poll());
            list.add(node.val);
            int sum = qSum.poll();
            sum += node.val;
            if (node.left == null && node.right == null) {
                if (target == sum) {
                    res.add(list);
                    continue;
                }
            }
            if (node.left != null) {
                qNode.add(node.left);
                qList.add(list);
                qSum.add(sum);
            }
            if (node.right != null) {
                qNode.add(node.right);
                qList.add(list);
                qSum.add(sum);
            }
        }
        return res;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return bfs(root, sum);
//        List<List<Integer>> res = new ArrayList<>();
//        dfs(root, sum, res, 0, new ArrayList<>());
//        return res;
    }

    public static void main(String[] args) {
//        [5,4,8,11,null,13,4,7,2,null,null,5,1]  22
        TreeNode root1 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root1.left = node4;
        TreeNode node11 = new TreeNode(11);
        node4.left = node11;
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        node11.left = node7;
        node11.right = node2;

        TreeNode node8 = new TreeNode(8);
        root1.right = node8;
        node8.left = new TreeNode(13);
        TreeNode node4_1 = new TreeNode(4);
        node8.right = node4_1;
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node4_1.left = node5;
        node4_1.right = node1;

        PathSumII113 t = new PathSumII113();
        List<List<Integer>> res = t.pathSum(root1, 22);
        System.out.println("result: " + Arrays.toString(res.toArray()));
    }
}
