package Trees;

public class TrimBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left,right;
    }

    private TreeNode trimBST(TreeNode root, int low,int high) {
        if(root == null) return null;

        if(root.val >= low && root.val <= high) {
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }
        else if(root.val < low) {
            root = trimBST(root.right,low,high);
        }
        else if(root.val > high) {
            root = trimBST(root.left,low,high);
        }

        return root;
    }
}
