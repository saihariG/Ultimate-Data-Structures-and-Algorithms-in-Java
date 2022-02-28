package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    static class TreeNode {
        TreeNode root;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        // queue to hold nodes
        Queue<TreeNode> q = new LinkedList<>();
        // queue to hold index of corresponding node in BFS order
        Queue<Integer> qIndex = new LinkedList<>();
        // adding first node
        q.add(root);
        // add first node's index (say 1)
        qIndex.add(1);

        int maxWidth = 0;
        // level order traversal
        while(!q.isEmpty()) {
            int size = q.size();
            // store the index of first node in a level
            int start = 0;
            // store the index of last node in a level
            int end = 0;

            for(int i = 0 ; i < size ; i++) {
                // remove from both queues
                TreeNode node = q.poll();
                int index = qIndex.poll();
                // if first node
                if(i == 0) {
                    // update start index
                    start = index;
                }
                // if last node
                if(i == size-1) {
                    // update end index
                    end = index;
                }
                // BFS logic to add left & right node to queue if present.
                if(node.left != null) {
                    q.add(node.left);
                    qIndex.add(index*2);
                }

                if(node.right != null) {
                    q.add(node.right);
                    qIndex.add(index*2 + 1);
                }
            }
            // update max width
            maxWidth = Math.max(maxWidth , end - start + 1);
        }

        return maxWidth;
    }
}
