package Tree.Path;

/*
* 437. 路径总和 III
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
* */

import Struct.Tree;
import Struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII437 {
    // 双重递归
    private int dfs(TreeNode node, int sum) {
        if (node == null) return 0;

        int count = 0;
        sum -= node.val;
        if (sum == 0) count=1;
        count += dfs(node.left, sum);
        count += dfs(node.right, sum);
        return count;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = dfs(root, sum);
        count += pathSum(root.left, sum);
        count += pathSum(root.right, sum);
        return count;
    }

    private Map<Integer, Integer> map = new HashMap<>();;

    // 前缀和
    private int prefixSum(TreeNode node, int preSum, int target) {
        if (node == null) return 0;
        preSum += node.val;
        // 上层节点中，
        int sol = map.getOrDefault(preSum - target, 0);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        sol += prefixSum(node.left, preSum, target);
        sol += prefixSum(node.right, preSum, target);
        map.put(preSum, map.getOrDefault(preSum, 0) - 1);
        return sol;
    }

    public int pathSum2(TreeNode root, int sum) {
        map.put(0, 1);
        return prefixSum(root,0, sum);
    }


        public static void main(String[] args) {
        PathSumIII437 t = new PathSumIII437();
        TreeNode root1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root1.right = node2;
        TreeNode node3 = new TreeNode(3);
        node2.right = node3;
//        TreeNode node4 = new TreeNode(4);
//        node3.right = node4;
//        TreeNode node5 = new TreeNode(5);
//        node4.right = node5;
        System.out.println(t.pathSum(root1, 3) + " == 2" );
        System.out.println(t.pathSum2(root1, 3) + " == 2" );
        System.out.println(t.pathSum2(root1, 0) + " == 0" );
        }
}
