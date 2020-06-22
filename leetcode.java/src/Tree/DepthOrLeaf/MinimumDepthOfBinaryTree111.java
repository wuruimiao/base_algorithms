package Tree.DepthOrLeaf;


import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 111. 二叉树的最小深度
* 给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class MinimumDepthOfBinaryTree111 {
    private int bfs(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth++;
//            System.out.println("depth++");
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
//                System.out.print(depth + " " + q.size() + " ");
//                System.out.println(node.val + " ");
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return depth;
    }


    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if ((node.left == null) && (node.right == null)) {
            return 1;
        }

//        TODO: 应该可以节支
        int min_depth = Integer.MAX_VALUE;
        if (node.left != null) {
            min_depth = Math.min(dfs(node.left), min_depth);
        }
        if (node.right != null) {
            min_depth = Math.min(dfs(node.right), min_depth);
        }

        return min_depth + 1;
    }

    public int minDepth(TreeNode root) {
//        return bfs(root);
         return dfs(root);
    }

    private void test1() {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println(this.minDepth(root) + "=2");
    }
    private void test2() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        System.out.println(this.minDepth(root) + "=2");
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree111 t = new MinimumDepthOfBinaryTree111();
        t.test1();
        t.test2();
    }
}
