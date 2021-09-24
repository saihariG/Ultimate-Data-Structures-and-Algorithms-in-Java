package LinkedList;

public class CircularSinglyLinkedList {

    private static ListNode tail;
    private static int length;

    private static class ListNode {

        private final int data;
        private ListNode next;

        public ListNode(int data) {

            this.data = data;
            this.next = null;

        }

    }
    public CircularSinglyLinkedList() {
        length = 0;
        tail = null;
    }

    private boolean isEmpty() {

        return length == 0;
    }

    private void getLength() {
        System.out.println("No. of Nodes : "+ length);
    }

    private void printList() {

        if(isEmpty()){

            System.out.println("List is Empty");
            return;
        }

        ListNode head = tail.next;
        while (head != tail) {

            System.out.print(head.data+" ");
            head = head.next;

        }
        System.out.println(head.data);
    }


    private void insertFirst(int value) {

        ListNode newNode = new ListNode(value);

        if(isEmpty()) {
            tail = newNode;
            tail.next = newNode;
            length++;
            return;
        }

        newNode.next = tail.next;
        tail.next = newNode;

        length++;

    }

    private void insertLast(int value) {

        ListNode newNode = new ListNode(value);
        if(isEmpty()) {
            tail = newNode;
            tail.next = newNode;
            length++;
            return;
        }

        if(length == 1) {
            tail.next = newNode;
            newNode.next = tail;
            tail = tail.next;
            length++;
            return;
        }

        ListNode head = tail.next;
        tail.next = newNode;
        newNode.next = head;
        tail = tail.next ;
        length++;


    }



    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();


        csll.insertFirst(3);
        csll.insertLast(8);
        csll.insertLast(10);
        csll.insertLast(1);
        csll.insertLast(11);

        csll.printList();
        csll.getLength();

    }

}
