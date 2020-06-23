package Tree.Path;

import Struct.TreeNode;
/*
* 112. 路径总和
* 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class PathSum112 {
    private boolean dfs(TreeNode node, int sum, int target) {
        if (node == null) {
            return false;
        }
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum == target;
        }
        return dfs(node.left, sum, target) || dfs(node.right, sum, target);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public static void main(String[] args) {
        PathSum112 t = new PathSum112();
        System.out.println(t.hasPathSum(null, 0) + "==false");

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        System.out.println(t.hasPathSum(root1, 1) + "==false");

        TreeNode root2 = new TreeNode(-2);
        root2.right = new TreeNode(-3);
        System.out.println(t.hasPathSum(root2, -5) + "==true");


    }
}
