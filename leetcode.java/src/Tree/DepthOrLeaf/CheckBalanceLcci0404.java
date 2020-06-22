package Tree.DepthOrLeaf;

import Struct.TreeNode;


/*
* 面试题 04.04. 检查平衡性
* 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。

示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。
示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-balance-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class CheckBalanceLcci0404 {
    private boolean isBalance = true;

    private int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = traversal(node.left);
        int right = traversal(node.right);
        isBalance = isBalance && Math.abs(left - right) <= 1;
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        traversal(root);
        return isBalance;
    }

    /*
     * 下面这个思路，对每个节点都继续往下递归，计算其高度，会有很多重复计算；
     * 不如上面，类似DP的思路，将递归变为迭代，从下往上计算高度，比较
     * */
    public boolean isBalanced2(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(depth(node.left) - depth(node.right)) > 1) {
            return false;
        }

        return dfs(node.right) && dfs(node.left);
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

}
