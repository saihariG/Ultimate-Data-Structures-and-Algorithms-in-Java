package Stack;

import java.util.EmptyStackException;

public class StackImplementationUsingLinkedList {

    private static class ListNode {

        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

    }

    private ListNode top ;
    private int size;

    public StackImplementationUsingLinkedList() {
        top = null;
        size = 0;
    }

    private int length() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void push(int data) {

         ListNode temp = new ListNode(data);
         temp.next = top;
         top = temp;
         size++;
    }

    private int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        int popped = top.data;
        top = top.next;
        size--;
        return popped;
    }

    private int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {

    }
}
