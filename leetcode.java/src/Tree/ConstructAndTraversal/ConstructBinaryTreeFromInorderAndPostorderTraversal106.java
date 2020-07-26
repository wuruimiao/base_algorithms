package Tree.ConstructAndTraversal;


import Struct.TreeNode;

import java.util.Arrays;

/*
* 106. 从中序与后序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
* */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
    private int[] inorder;
    private int[] postorder;

    private TreeNode dfs(int inL, int inR, int postL, int postR) {
        System.out.println(inL + " " + inR + " " + postL + " " + postR);
        if (inL > inR) return null;
        TreeNode root = new TreeNode(postorder[postR]);
        if (postL == postR) return root;

        int rInIdx = inL, lNNum = 0;
        for (; rInIdx <= inR ; rInIdx++) {
            if (inorder[rInIdx] == postorder[postR]) break;
            lNNum++;
        }

        root.left = dfs(inL, rInIdx-1, postL, postL + lNNum - 1);
        root.right = dfs(rInIdx + 1, inR, postL + lNNum, postR - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        this.inorder = inorder;
        this.postorder = postorder;
        return dfs(0, inorder.length - 1, 0, postorder.length -1 );
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal106 t = new ConstructBinaryTreeFromInorderAndPostorderTraversal106();
        TreeNode root1 = t.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

        BinaryTreeLevelOrderTraversal102 tp = new BinaryTreeLevelOrderTraversal102();
        System.out.println(Arrays.toString(tp.levelOrder2(root1).toArray()));

        TreeNode root2 = t.buildTree(new int[]{}, new int[]{});

        TreeNode root3 = t.buildTree(new int[]{2, 1}, new int[]{2, 1});
        System.out.println(Arrays.toString(tp.levelOrder2(root3).toArray()));

        TreeNode root4 = t.buildTree(new int[]{1, 2}, new int[]{2, 1});
        System.out.println(Arrays.toString(tp.levelOrder2(root4).toArray()));

    }
}
