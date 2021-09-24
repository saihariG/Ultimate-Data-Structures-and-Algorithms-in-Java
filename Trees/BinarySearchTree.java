package Trees;

import java.util.Stack;

public class BinarySearchTree {

    private TreeNode root;

    static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private void insert(int value) {
        root = insert(root,value);
    }

    private TreeNode insert(TreeNode root,int value) {
        if(root == null) {
            root = new TreeNode(value);
            return root;
        }

        if(value < root.data) {
            root.left = insert(root.left,value);
        }
        else {
            root.right = insert(root.right,value);
        }
        return root;
    }

    private void inOrderIterative() {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null) {

            if(temp != null) {
               stack.push(temp);
               temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }

    }

    private TreeNode search(int key) {
        return search(root,key);
    }

    private TreeNode search(TreeNode root,int key) {
        if(root == null || root.data == key) {
            return root;
        }
        if(key < root.data) {
            return search(root.left,key);
        }
        else {
            return search(root.right,key);
        }
    }

    private void delete(int key) {
        deleteRecursively(root,key);
    }

    private TreeNode deleteRecursively(TreeNode root , int key) {

        /* Base Case: If the tree is empty */
        if (root == null) {
            return root;
        }

        if(key < root.data) {
          root.left = deleteRecursively(root.left , key);
        }
        else if(key > root.data) {
            root.right = deleteRecursively(root.right , key);
        }
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {

            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.data = minValue(root.right);


            // Delete the inorder successor
            root.right = deleteRecursively(root.right, root.data);

        }

        return root;

    }


    private int minValue(TreeNode root)
    {
        int minV = root.data;

        while (root.left != null)
        {
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }


    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        // 11,6,8,19,4,10,5,17,43,49,31
        bst.insert(11);
        bst.insert(6);
        bst.insert(8);
        bst.insert(19);
        bst.insert(4);
        bst.insert(10);
        bst.insert(5);
        bst.insert(17);
        bst.insert(43);
        bst.insert(49);
        bst.insert(31);

        /*
         *
         *
         *          11
         *       /      \
         *      6         19
         *    /   \     /    \
         *   4     8   17     43
         *    \     \       /   \
         *     5     10    31    49
         */



        bst.inOrderIterative();

        System.out.println();
        bst.delete(5);
        bst.inOrderIterative();
        System.out.println();
        bst.delete(8);
        bst.inOrderIterative();
        System.out.println();
        bst.delete(19);
        bst.inOrderIterative();

        System.out.println();
        if(bst.search(10) != null) {
            System.out.println("Key Found");
        }else {
            System.out.println("key not Found");
        }

    }

}
