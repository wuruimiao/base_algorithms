package Tree.DepthOrLeaf;

import Struct.Node;

/*
* 559. N叉树的最大深度
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

例如，给定一个 3叉树 :


         1
      /  |  \
     3   2  4
   /  \
  5    6


我们应返回其最大深度，3。

说明:

树的深度不会超过 1000。
树的节点总不会超过 5000。
* */
public class MaximumDepthOfNAryTree559 {
    // 不必判断是否到了叶子节点
    // 若未到叶子节点，但其中某一支为null，则其返回0；
    // 而叶子节点必然深度>0
    private int dfs(Node node) {
        if (node == null) return 0;
        int max = 0;
        for (Node child: node.children) {
            max = Math.max(dfs(child), max);
        }
        max += 1;
        return max;
    }
    public int maxDepth(Node root) {
        return dfs(root);
    }
}
