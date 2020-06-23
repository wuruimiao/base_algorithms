package Tree.ConstructAndTraversal;


/*
* 面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5
* */

import Struct.TreeNode;

import java.util.Arrays;

public class MinimumHeightTreeLcci0402 {
    private TreeNode con(int left, int right, int[] nums) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = con(left, mid - 1, nums);
        node.right = con(mid + 1, right, nums);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return con(0, nums.length - 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        MinimumHeightTreeLcci0402 t = new MinimumHeightTreeLcci0402();

        TreeNode root = t.sortedArrayToBST(nums);
        System.out.println(Arrays.toString(new BinaryTreeLevelOrderTraversal102().levelOrder(root).toArray()));
    }
}
