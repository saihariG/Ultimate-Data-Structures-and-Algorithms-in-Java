package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    /*
     *              10                                           10
     *            /    \            Inversion                 /      \
     *          20        50      ------------>             50         20
     *        /    \     /   \                            /    \      /   \
     *       30    40   null   60                        60   null   40    30
     */
    private static TreeNode root;
    static class TreeNode {
        int data;
        TreeNode left,right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    private static void createBinaryTree() {

        TreeNode first = new TreeNode(10);
        TreeNode second = new TreeNode(20);
        TreeNode third = new TreeNode(50);
        TreeNode fourth = new TreeNode(30);
        TreeNode fifth = new TreeNode(40);
        TreeNode six = new TreeNode(60);


        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.right = six;

    }


    private static void invert(TreeNode root) {
        if(root == null) {
            return;
        }

        // swapping
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    private static void levelOrderTraversal() {
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

        createBinaryTree();

        System.out.print("Before Inverting : ");
        levelOrderTraversal();

        invert(root);

        System.out.print("\nAfter Inverting : ");
        levelOrderTraversal();

    }
}
