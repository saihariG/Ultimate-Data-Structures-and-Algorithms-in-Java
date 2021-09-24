package Stack;

import java.util.*;

public class prefixToInfix {

    private static String preToIn(String prefix) {


        char[] prefixExp = prefix.toCharArray();

        Stack<String> stack = new Stack<>();

        for(int i = prefixExp.length-1 ; i >= 0 ; i-- ) {

              if(isOperator(prefixExp[i]))  {
                  String s1 = stack.pop();
                  String s2 = stack.pop();
                  stack.push("("+s1 + prefixExp[i] + s2 + ")");
              }
              else {
                  stack.push(prefixExp[i]+""); // + "" is added so it will be a String
              }

        }

        return stack.pop();

    }

    private static boolean isOperator(char x) {

        return switch (x) {
            case '+', '-', '*', '/' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prefix :");
        String prefix = scanner.nextLine();

        System.out.println("Infix Expression is :"+preToIn(prefix));
    }
}
