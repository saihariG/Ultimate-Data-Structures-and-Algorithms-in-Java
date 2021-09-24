package Queue;

import java.util.NoSuchElementException;

public class QueueImplementationUsingLinkedList {

    static class ListNode {
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private static ListNode front ;
    private static ListNode rear ;

    private int length;

    public QueueImplementationUsingLinkedList() {
        length = 0;
        front = null;
        rear = null;
    }

    private int length() {
        return length;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private void enqueue(int data) {

        ListNode temp = new ListNode(data);
        if(isEmpty()) {
            front = temp;
            rear = temp;
            length++;
            return;
        }

        rear.next = temp;
        rear = temp;
        length++;

    }

    private int dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        int result = front.data;
        if(length == 1) {
            front = null;
            rear = null;
            length--;
            return result;
        }

        front = front.next;
        length--;
        return result;
    }

    private int last() {
        if(isEmpty()) throw new NoSuchElementException("Queue is Empty");
        return rear.data;
    }

    private int front() {
        if(isEmpty()) throw new NoSuchElementException("Queue is Empty");
        return front.data;
    }

    public static void main(String[] args) {
        QueueImplementationUsingLinkedList qill = new QueueImplementationUsingLinkedList();

        System.out.println("length" + qill.length());
        qill.enqueue(2);
        qill.enqueue(3);
        qill.enqueue(10);
        System.out.println("length" + qill.length());
        System.out.println("dequeued element"+qill.dequeue());
        System.out.println("dequeued element"+qill.dequeue());
        System.out.println("length" + qill.length());

    }

}
