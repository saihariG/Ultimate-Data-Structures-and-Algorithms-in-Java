package LinkedList;

import java.util.*;

public class DoublyLinkedList {

    
    private static int length;
    private static ListNode head;
    private static ListNode tail;

    private static class ListNode {

        private final int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data){
            this.data = data;

        }

    }
    
    public DoublyLinkedList() {

        head = null;
        tail = null;
        length = 0;
        
    }
    
    private boolean isEmpty() {
        return length == 0;
    }
    
    private void getLength() {
        System.out.println(length);
    }

    private void printList(ListNode head) {

        if(isEmpty()) {
            return;
        }
        ListNode current = head;

        while (current != null) {

            System.out.print(current.data + "-->");
            current = current.next;

        }
        System.out.println("null");

    }

    private void reverseList(ListNode tail) {

        ListNode current = tail;

        while (current != null) {
            System.out.print(current.data+"-->");
            current = current.previous;
        }
        System.out.println("null");
    }

    private void insertFirst(int value) {

        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }else {

            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        length++;

    }

    private void insertLast(int value) {

        ListNode newNode = new ListNode(value);

        if(isEmpty()) {
            head = newNode;
        }else {

            tail.next = newNode;
            newNode.previous = tail;

        }
        tail = newNode;
        length++;
    }

    private void deleteFirst() {

        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }

        ListNode temp = head;

        temp.next.previous = null;
        head = temp.next;
        temp.next = null;
        length--;

    }

    private void deleteLast() {

        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        ListNode temp = tail;
        temp.previous.next = null;
        tail = temp.previous;
        temp.previous = null;
        length--;

    }



    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertFirst(10);
        dll.insertLast(8);
        dll.insertLast(2);

        dll.printList(head);
        dll.deleteLast();
        dll.deleteFirst();

        dll.printList(head);
        dll.reverseList(tail);

        dll.getLength();

    }


}
