package Tree.Parent;

/*
* 236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

          3
       /     \
      5      1
    / \    /  \
   6  2   0   8
     / \
    7  4



示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。


说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
* */

import Struct.TreeNode;

import java.util.*;

/*
* 主要考虑共边和不共边两种情况
* */
public class LowestCommonAncestorOfABinaryTree236 {
    private TreeNode dfs(TreeNode node, boolean[] flags, int p, int q) {
        if (node == null) return null;
        boolean fp= flags[0], fq = flags[1];
        if (node.val == p) flags[0] = true;
        if (node.val == q) flags[1] = true;
        TreeNode n;

        n = dfs(node.left, flags, p, q);
//        System.out.println("left return " + node.val + " " + fp + " " +fq + " " + Arrays.toString(flags) + " " + n);
        if (!(fp || fq) && flags[0] && flags[1]) return Objects.requireNonNullElse(n, node);

        n = dfs(node.right, flags, p, q);
//        System.out.println("right return " + node.val + " " + fp + " " +fq + " " + Arrays.toString(flags) + " " + n);
        if (!(fp || fq) && flags[0] && flags[1]) return Objects.requireNonNullElse(n, node);
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, new boolean[]{false, false}, p.val, q.val);
    }

    private void traversal(TreeNode node, Map<Integer, TreeNode> parent) {
        if (node.left != null) {
            parent.put(node.left.val, node);
            traversal(node.left, parent);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
            traversal(node.right, parent);
        }
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parent = new HashMap<>();
        traversal(root, parent);
        Set<Integer> visited = new HashSet<>();
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }


    private void test1() {
        TreeNode root1 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        root1.left = node5;
        root1.right = node1;
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        node5.left = node6;
        node5.right = node2;
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node1.left = node0;
        node1.right = node8;
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node2.left = node7;
        node2.right = node4;
        System.out.println(this.lowestCommonAncestor(root1, node5, node1).val + "==3");
    }

    private void test2() {
        TreeNode root1 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        root1.left = node5;
        root1.right = node1;
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        node5.left = node6;
        node5.right = node2;
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node1.left = node0;
        node1.right = node8;
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node2.left = node7;
        node2.right = node4;
        System.out.println(this.lowestCommonAncestor(root1, node5, node4).val + "==5");
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree236 t = new LowestCommonAncestorOfABinaryTree236();
        t.test1();
        t.test2();
    }
}
