package Tree.A;

import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 100. 相同的树
* 给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
示例 3:

输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/same-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class SameTree100 {
    private boolean isDiffNode(TreeNode nodeP, TreeNode nodeQ) {
        if (nodeP == null && nodeQ == null) {
            return false;
        }
        if (nodeP == null ^ nodeQ == null) {
            return true;
        }
        return nodeP.val != nodeQ.val;
    }
    private boolean dfs(TreeNode nodeP, TreeNode nodeQ) {
        if (nodeP == null && nodeQ == null) {
            return true;
        }
        if (isDiffNode(nodeP, nodeQ)) {
            return false;
        }
        assert nodeP != null;
        return dfs(nodeP.left, nodeQ.left)&& dfs(nodeP.right, nodeQ.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        return bfs(p, q);
    }

    private boolean bfs(TreeNode nodeP, TreeNode nodeQ) {
        if (nodeP == null && nodeQ == null) return true;
        if (isDiffNode(nodeP, nodeQ)) return false;

        Queue<TreeNode> queueP = new ArrayDeque<>();
        Queue<TreeNode> queueQ= new ArrayDeque<>();
        if (nodeP != null) queueP.add(nodeP);
        if (nodeQ != null) queueQ.add(nodeQ);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode p = queueP.poll();
            TreeNode q = queueQ.poll();
            if (isDiffNode(p.left, q.left)) return false;
            if (isDiffNode(p.right, q.right)) return false;
            if (p.left != null) queueP.add(p.left);
            if (p.right != null) queueP.add(p.right);
            if (q.left != null) queueQ.add(q.left);
            if (q.right != null) queueQ.add(q.right);
        }
        return true;
    }

}
