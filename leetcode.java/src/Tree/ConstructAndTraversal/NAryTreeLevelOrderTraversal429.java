package Tree.ConstructAndTraversal;

import Struct.Node;

import java.util.*;

/*
* 429. N叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :


返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]


说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。
* */
public class NAryTreeLevelOrderTraversal429 {
    private List<List<Integer>> bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.val);
                q.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(Node root) {
        return bfs(root);
    }
}
