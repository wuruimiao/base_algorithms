package Struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
    private void preOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        System.out.print(node.val + " ");
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, result);
        result.add(node.val);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right, result);
    }

    private void postOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.val);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
//         9
//       /   \
//      3    20
//     / \  /  \
//    2  6 15  31
        TreeNode root = new TreeNode(9);

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);

        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node31 = new TreeNode(31);

        root.left = node3;
        node3.left = node2;
        node3.right = node6;

        root.right = node20;
        node20.left = node15;
        node20.right = node31;

        Tree t = new Tree();

        List<Integer> preOrderRes = new ArrayList<>();
        t.preOrderTraversal(root, preOrderRes);
        System.out.println("前序遍历结果：" + Arrays.toString(preOrderRes.toArray()));

        List<Integer> inOrderRes = new ArrayList<>();
        t.inOrderTraversal(root, inOrderRes);
        System.out.println("中序遍历结果：" + Arrays.toString(inOrderRes.toArray()));

        List<Integer> postOrderRes = new ArrayList<>();
        t.postOrderTraversal(root, postOrderRes);
        System.out.println("后序遍历结果：" + Arrays.toString(postOrderRes.toArray()));


    }
}
