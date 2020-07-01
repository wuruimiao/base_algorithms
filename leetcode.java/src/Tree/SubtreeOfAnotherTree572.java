package Tree;

/*
* 572. 另一个树的子树
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。
* */

import Struct.TreeNode;

public class SubtreeOfAnotherTree572 {
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null ^ s == null) return false;
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSameTree(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.right = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root1.left = node4;
        node4.left = new TreeNode(1);
        node4.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);

        SubtreeOfAnotherTree572 t = new SubtreeOfAnotherTree572();
        System.out.println(t.isSubtree(root1, root2) + " == true");
    }
}
