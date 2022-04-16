package Trees;

import java.util.Stack;

// LeetCode 538.
public class BSTtoGreaterTree {
    static class TreeNode {
        int val;
        TreeNode left,right;
    }
    public TreeNode convertBST(TreeNode root) {

        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || node != null) {

            // push all the nodes in the right subtree
            while(node != null) {
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;

        }

        return root;
    }
}


/* Recursive approach
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;

        convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
} */
