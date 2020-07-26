package Tree.ConstructAndTraversal;

import Struct.TreeNode;

import java.util.Arrays;

/*
* 889. 根据前序和后序遍历构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
返回与给定的前序和后序遍历匹配的任何二叉树。

 pre 和 post 遍历中的值是不同的正整数。



示例：

输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
输出：[1,2,3,4,5,6,7]


提示：

1 <= pre.length == post.length <= 30
pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
* */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal889 {
    private void printTree(TreeNode node) {
        BinaryTreeLevelOrderTraversal102 t = new BinaryTreeLevelOrderTraversal102();
        System.out.println(Arrays.toString(t.levelOrder2(node).toArray()));
    }

    private int[] pre;
    private int[] post;

//     TODO：还有其他解法吗？
    private TreeNode dfs(int preL, int preR, int postL, int postR) {
//        System.out.println(preL + " " + preR + " " + postL + " " + postR);
        if (preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        // postL == postR 也可以，都表示，root没有子树了
        if (preL == preR) return root;

        // 默认根后面跟的第一个子序列为左子树
        // 先序和后序都不分左右
        int lNIdx = preL + 1;
        int lNNum = 0;
        for (int i = postL; i <= postR; i++) {
            if (pre[lNIdx] == post[i]) break;
            lNNum++;
        }
        root.left = dfs(lNIdx, lNIdx + lNNum, postL, postL + lNNum);
//        System.out.println("enter right");

        // 右子树位置
        int rNIdx = lNIdx + lNNum + 1;
        root.right = dfs(rNIdx, preR, postL + lNNum + 1, postR);
        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return dfs(0, pre.length - 1, 0, post.length - 1);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal889 t = new ConstructBinaryTreeFromPreorderAndPostorderTraversal889();
        TreeNode root1 = t.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
//                                                        0 1 2 3 4 5 6             0 1 2 3 4 5 6
        t.printTree(root1);
        TreeNode root2 = t.constructFromPrePost(new int[]{2, 1}, new int[]{1, 2});
        t.printTree(root2);
    }
}
