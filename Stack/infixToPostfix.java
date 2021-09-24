package Stack;

import  java.util.*;

public class infixToPostfix
{
    private static int checkPrecedence(char ch) {

        if(ch == '+' || ch == '-') {
            return 1;
        }
        else if(ch == '*' || ch == '/') {
            return 2;
        }
        else if(ch == '^') {
            return 3;
        }
        else {
            return 0;
        }

    }

    private static String infixToPost(String infixExp) {

        Stack<Character> stack = new Stack<>();
        stack.push('#');

        String postfix = "";

        char[] inchars = infixExp.toCharArray();

        for (char inchar : inchars) {

            if (Character.isDigit(inchar) || Character.isLetter(inchar)) {
                postfix = postfix + inchar;
            }
            else if (inchar == '(') {
                stack.push('(');
            }
            else if (inchar == '^') {
                stack.push('^');
            }
            else if (inchar == ')') {

                while (stack.peek() != '#' && stack.peek() != '(') {

                    postfix = postfix + stack.peek();
                    stack.pop();

                }
                stack.pop();
            }
            else if (checkPrecedence(inchar) > checkPrecedence(stack.peek())) {
                stack.push(inchar);
            }
            else {
                while (stack.peek() != '#' && checkPrecedence(inchar) <= checkPrecedence(stack.peek())) {

                    postfix = postfix + stack.peek();
                    stack.pop();
                }
                stack.push(inchar);

            }
        }

        while(stack.peek() != '#') {

            postfix = postfix + stack.peek();   //.concat(stack.peek().toString());
            stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter infix :");
        String infixExp = s.nextLine();
        System.out.println("Postfix Expression is: "+infixToPost(infixExp));

    }

}





