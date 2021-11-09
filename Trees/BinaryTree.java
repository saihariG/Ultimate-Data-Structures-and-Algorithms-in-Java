package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    private static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private final int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private void createBinaryTree() {

        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        /*         1
                 /    \
                2      3
               / \   /   \
              /   \   null
             4     5
            /  \  / \
           null  null

         */

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;
    }

    private void createBinaryTree1() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

          /**
                   1
                 /    \
               2       3
             /   \    /  \
            4     5  6    7

         */

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.left = six;
        third.right = seven;

    }

    private void recursivePreOrderTraversal(TreeNode root) {

        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        recursivePreOrderTraversal(root.left);
        recursivePreOrderTraversal(root.right);
    }

    private void recursiveInOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        recursiveInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        recursiveInOrderTraversal(root.right);
    }

    private void iterativePreOrderTraversal() {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print( temp.data + " ");

            if(temp.right != null) {
                stack.push(temp.right);
            }

            if(temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    private void iterativeInOrderTraversal1() {

        if(root == null)  {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(!stack.isEmpty() || temp != null) {
            if(temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }

    }

    private void recursivePostOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        recursivePostOrderTraversal(root.left);
        recursivePostOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    private void iterativePostOrderTraversal() {
        if(root == null) {
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                TreeNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else {
                    current = temp;
                }
            }
        }

    }

    private void levelOrderTraversal() {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");

            if(temp.left != null) {
                queue.offer(temp.left);
            }

            if(temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.createBinaryTree1();
        binaryTree.levelOrderTraversal();

    }

}