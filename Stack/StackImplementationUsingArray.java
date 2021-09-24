package Stack;

import java.util.*;

public class StackImplementationUsingArray {


    private int top;

    private static int[] stack;

    public StackImplementationUsingArray(int c) {

        top = -1;
        stack = new int[c];

    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {

        return top == 4 ;
    }

    private void push(int data) {

        if(isFull()) {
            throw new StackOverflowError();
        }

        top++;
        stack[top] = data;

    }

    private int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        int popped = stack[top];
        top--;
        return popped;
    }

    private int peek() {

        if(isEmpty()) {
            throw new EmptyStackException();

        }
        return stack[top];

    }

    public static void main(String[] args) {

        StackImplementationUsingArray stackImplementationUsingArray = new StackImplementationUsingArray(5);
        stackImplementationUsingArray.push(10);
        stackImplementationUsingArray.push(15);
        stackImplementationUsingArray.push(20);
        System.out.println(stackImplementationUsingArray.peek());
        System.out.println(stackImplementationUsingArray.pop());
        System.out.println(stackImplementationUsingArray.peek());

    }

}
