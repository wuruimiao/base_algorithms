package DP;

import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
* 337. 打家劫舍 III https://leetcode-cn.com/problems/house-robber-iii/
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
* */
public class HouseRobberIII337 {
    // [抢本节点，不抢本节点]
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int []left = dfs(node.left);
        int []right = dfs(node.right);
//        System.out.println(node.val + " " + Arrays.toString(left) + Arrays.toString(right));
        return new int[]{
                node.val + left[1] + right[1],
                Math.max(left[0], left[1]) + Math.max(right[0], right[1])
        };
    }

    private int dfsForce(TreeNode node) {
        if (node == null) return 0;
        int money = node.val;
        if (node.left != null) money += dfsForce(node.left.left) + dfsForce(node.left.right);
        if (node.right != null)money += dfsForce(node.right.left) + dfsForce(node.right.right);
        return Math.max(money, dfsForce(node.left) + dfsForce(node.right));
    }

    public int rob(TreeNode root) {
//        return dfsForce(root);
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public static void main(String[] args) {
        HouseRobberIII337 t = new HouseRobberIII337();

        TreeNode root1 = new TreeNode(3);

        TreeNode node12 = new TreeNode(2);
        root1.left = node12;
        node12.right = new TreeNode(3);

        TreeNode node13 = new TreeNode(3);
        root1.right = node13;
        node13.right = new TreeNode(1);
        System.out.println(t.rob(root1) + "== 7");


        TreeNode root2 = new TreeNode(3);

        TreeNode node24 = new TreeNode(4);
        root2.left = node24;
        node24.left = new TreeNode(1);
        node24.right = new TreeNode(3);

        TreeNode node25 = new TreeNode(5);
        root2.right = node25;
        node25.right = new TreeNode(1);
        System.out.println(t.rob(root2) + "== 9");
    }
}
