package Stack;

import java.util.*;

public class infixToPrefix {

     private static int checkPrecedence(char ch) {
        if(ch == '+' || ch == '-') {
            return 1;
        }
        else if(ch == '*' || ch == '/') {
            return 2;
        }
        else if(ch == '^'){
            return 3;
        }
        else {
            return 0;
        }
    }

    private static String inToPost(String infix) {

        Stack<Character> stack = new Stack<>();
        stack.push('#');

        String postFix = "";
        char[] charArray = infix.toCharArray();

        for(char incomingChar : charArray) {

            if(Character.isLetter(incomingChar) || Character.isDigit(incomingChar)) {
                postFix = postFix + incomingChar;
            }
            else if(incomingChar == '(') {
                stack.push('(');
            }
            else if(incomingChar == '^') {
                stack.push('^');
            }
            else if(incomingChar == ')') {

                while (stack.peek() != '#' && stack.peek() != '(') {
                    postFix = postFix + stack.peek();
                    stack.pop();
                }
                stack.pop();
            }
            else if(checkPrecedence(incomingChar) > checkPrecedence(stack.peek())) {
                stack.push(incomingChar);
            }
            else {

                while (stack.peek() != '#' && checkPrecedence(incomingChar) < checkPrecedence(incomingChar)) {
                    postFix = postFix + stack.peek();
                    stack.pop();
                }
                stack.push(incomingChar);
            }

        }

        while (stack.peek() != '#') {
            postFix = postFix + stack.peek();
            stack.pop();
        }

        return postFix;
    }

    private static String inToPre(String givenInfix) {

        StringBuilder stringBuilder = new StringBuilder(givenInfix);
        stringBuilder = stringBuilder.reverse();
        String reversedGivenInfix = stringBuilder.toString();

        char[] reversedGivenInfixArray = reversedGivenInfix.toCharArray();

        for(int i = 0 ; i < reversedGivenInfixArray.length ; i++) {
            if(reversedGivenInfixArray[i] == '(') {
                reversedGivenInfixArray[i] = ')';
            }
            else if(reversedGivenInfixArray[i] == ')') {
                reversedGivenInfixArray[i] = '(';
            }
        }

        String prefix = inToPost(new String(reversedGivenInfixArray));

        StringBuilder prefixExp = new StringBuilder(prefix);
        prefixExp = prefixExp.reverse();
        prefix = prefixExp.toString();
        return prefix;
    }


    public static void main(String[] args) {

        System.out.print("Enter Infix : ");
        Scanner scanner = new Scanner(System.in);

        String givenInfix = scanner.nextLine();

        System.out.println("Prefix Expression is: "+inToPre(givenInfix));


    }

}
