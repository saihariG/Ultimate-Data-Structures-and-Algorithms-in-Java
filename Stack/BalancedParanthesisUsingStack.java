package Stack;


import java.util.Stack;

public class BalancedParanthesisUsingStack {

    /***
     * Algorithm :
     * @return boolean
     * 1. Define a Stack
     * 2. scan the String and parse the brackets
     * 3. if the bracket is left bracket it means another bracket suppose to
     *    complete it. keep pushing into the stack
     *
     * 4. if it's a right bracket check if the top item in the stack equals its reverseBracket
     * 5. if it is not equal or if stack is empty , it means they are not balanced
     * 6. After parsing , if the stack is empty , then brackets are balanced
     */
    public static boolean isBracketBalanced(String str) {

        Stack<Character> stack = new Stack<>();
        char[] bracket = str.toCharArray();

        for(char ch : bracket) {

            char reverseBracket = getReverseBracket(ch);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
            else if(stack.isEmpty() || stack.pop() != reverseBracket) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static char getReverseBracket(char ch) {
        if(ch == '{') {
            return '}';
        }
        else if(ch == '[') {
            return ']';
        }
        else if(ch == '(') {
            return ')';
        }
        else if(ch == '}') {
            return '{';
        }
        else if(ch == ']') {
            return '[';
        }
        else {
            return '(';
        }
    }

    public static void main(String[] args) {

        String test1 = "{([])}";
        String test2 = "{([)}";
        String test3 = "{([])";
        String test4 = "{[()]}";

        System.out.println(isBracketBalanced(test1)); // true
        System.out.println(isBracketBalanced(test2)); // false
        System.out.println(isBracketBalanced(test3)); // false
        System.out.println(isBracketBalanced(test4)); // true

    }

}