package LinkedList;

public class CircularDoublyLinkedList {

    private static ListNode head;
    private static ListNode tail;
    private int length;

    private static class ListNode {

        private final int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

    }

    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    private void getLength() {
        System.out.println("Length of the list is: " + length);
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private void printList() {

        if(isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        if(length == 1) {
            System.out.println(head.data);
            return;
        }

        ListNode current  = head;

        while (current != tail) {

            System.out.print(current.data + " ");
            current = current.next;

        }

        System.out.println(current.data);

    }

    private void printReverse() {

        if(isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        if(length == 1) {
            System.out.println("Reversed List : "+tail.data);
            return;
        }


        ListNode current = tail;

        System.out.print("Reversed List : ");
        while (current != head) {

                System.out.print(current.data + " ");
                current = current.previous;

        }

        System.out.println(current.data);
    }

    private void insertFirst(int value) {

        ListNode newNode = new ListNode(value);

        if(isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            length++;
            return;
        }


        newNode.next = head;
        head.previous = newNode;
        head = newNode;
        tail.next = newNode;
        length++;

    }

    private void insertLast(int value) {

        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            length++;
            return;
        }

        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        tail.next = head;
        length++;


    }

    public static void main(String[] args) {

        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        cdll.insertLast(11);
        cdll.insertFirst(2);
        cdll.insertFirst(10);

        cdll.printList();
        cdll.printReverse();

        cdll.getLength();

    }

}
