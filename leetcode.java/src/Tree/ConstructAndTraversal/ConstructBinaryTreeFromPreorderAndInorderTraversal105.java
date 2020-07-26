package Tree.ConstructAndTraversal;

import Struct.TreeNode;

import java.util.Arrays;

/*
* 105. 从前序与中序遍历序列构造二叉树
* 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    private int[]preorder;
    private int[]inorder;
    private TreeNode dfs(int preL, int preR, int inL, int inR) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        if (preL == preR) return root;

        int rInIdx = inL, lNNum = 0;
        for (;rInIdx <= inR; rInIdx++){
            if (inorder[rInIdx] == preorder[preL]) break;
            lNNum++;
        }
        root.left = dfs(preL+1, preL+lNNum, inL, inL +lNNum-1);
        root.right = dfs(preL+ 1 + lNNum, preR, inL + lNNum+1, inR);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return dfs(0, preorder.length -1, 0, inorder.length-1);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal105 t = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();
        TreeNode root1 = t.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});

        BinaryTreeLevelOrderTraversal102 tp = new BinaryTreeLevelOrderTraversal102();
        System.out.println(Arrays.toString(tp.levelOrder2(root1).toArray()));
    }
}
