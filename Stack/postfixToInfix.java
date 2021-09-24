package Stack;

import java.util.*;

public class postfixToInfix {

    private static String postToIn(String postfix) {

        char[] postfixExp = postfix.toCharArray() ;

        Stack<String> stack = new Stack<>();

        for(int i = 0 ; i  < postfixExp.length ; i++) {
            if(isOperator(postfixExp[i])) {
                String s2 = stack.pop();
                String s1 = stack.pop();
                stack.push("(" + s1 + postfixExp[i] + s2 + ")");
            }
            else {
                stack.push(postfixExp[i]+"");
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(char x)  {

        return switch (x) {
            case '+','-','*','/' -> true ;
            default -> false ;
        };
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter postfix :");
        String postfix = scanner.nextLine();
        System.out.println("infix Exp is :" + postToIn(postfix));
    }

}
