package Tree.A;

import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 101. 对称二叉树
* 给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 

进阶：

你可以运用递归和迭代两种方法解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SymmetricTree101 {
    private boolean isDiffNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return false;
        }
        if (p == null ^ q == null) {
            return true;
        }
        return p.val != q.val;
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (isDiffNode(left, right)) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    private boolean bfs(TreeNode left, TreeNode right) {
        Queue<TreeNode> queueL = new ArrayDeque<>();
        Queue<TreeNode> queueR = new ArrayDeque<>();
        if (left != null) queueL.add(left);
        if (right != null) queueR.add(right);
        if (isDiffNode(left, right)) return false;
        while (!queueL.isEmpty() && !queueR.isEmpty()) {
            TreeNode l = queueL.poll();
            TreeNode r = queueR.poll();
            if (isDiffNode(l.left, r.right) || isDiffNode(l.right, r.left)) return false;
            if (l.left!=null) {
                queueL.add(l.left);
                queueR.add(r.right);
            }
            if (l.right != null) {
                queueL.add(l.right);
                queueR.add(r.left);
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }
}
