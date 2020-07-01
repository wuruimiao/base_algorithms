package Tree;

/*
* 563. 二叉树的坡度
给定一个二叉树，计算整个树的坡度。

一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。

整个树的坡度就是其所有节点的坡度之和。


示例：

输入：
         1
       /   \
      2     3
输出：1
解释：
结点 2 的坡度: 0
结点 3 的坡度: 0
结点 1 的坡度: |2-3| = 1
树的坡度 : 0 + 0 + 1 = 1


提示：

任何子树的结点的和不会超过 32 位整数的范围。
坡度的值不会超过 32 位整数的范围。
* */

import Struct.TreeNode;

public class BinaryTreeTilt563 {
    int tilt;
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        tilt += Math.abs(l - r);
        return l + r + node.val;
    }

    public int findTilt(TreeNode root) {
        tilt = 0;
        dfs(root);
        return tilt;
    }
}
