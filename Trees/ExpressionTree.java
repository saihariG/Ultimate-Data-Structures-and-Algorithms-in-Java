package Trees;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionTree {

    private static TreeNode root;

    static class TreeNode {

        private final char data;
        private TreeNode left , right;

        public TreeNode(char data) {
            this.data = data;
        }

    }

    private static boolean isOperator(char ch) {

        return ch == '+' || ch == '-' || ch == '*' || ch == '/';

    }

    private static void constructExpressionTree(String postFixExp) {

        Stack<TreeNode> stack = new Stack<>();

        for(int i = 0 ; i < postFixExp.length() ; i++) {

            char ch = postFixExp.charAt(i);

            if(Character.isLetter(ch)) {

                TreeNode node = new TreeNode(ch);
                stack.push(node);
            }
            else if(isOperator(ch)) {
                TreeNode node = new TreeNode(ch);

                TreeNode right = stack.pop();

                node.left = stack.pop();
                node.right = right;

                stack.push(node);

            }


        }

        root = stack.pop();

    }

    private static void postTraversal(TreeNode root) {

        if(root == null) {
            return;
        }

        postTraversal(root.left);
        postTraversal(root.right);
        System.out.print(root.data);

    }

    private static void preTraversal(TreeNode root) {

        if(root == null) {
            return;
        }

        System.out.print(root.data);
        preTraversal(root.left);
        preTraversal(root.right);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Postfix Expression : ");

        String postfixExp = sc.nextLine();


        constructExpressionTree(postfixExp);
        postTraversal(root);
        System.out.println();
        preTraversal(root);
    }
}
