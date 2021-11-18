package LinkedList;

import java.util.Scanner;

public class MergeSortedLinkedLists {

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public ListNode head;
        public ListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            ListNode node = new ListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(ListNode node)  {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;

            if (node != null) {
                System.out.print(" ");
            }
        }
    }

    /*
      Given pointers to the heads of two sorted linked lists, merge them into a single sorted linked list. Either head pointer may be null meaning that the corresponding list is empty.
     */
    static ListNode mergeLists(ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        ListNode current1 = head1, current2 = head2;
        ListNode head = null, tail = null;

        if(current1.data <= current2.data) {
            head = current1;
            tail = current1;
            current1= current1.next;
        }
        else {
            head = current2;
            tail = current2;
            current2 =  current2.next;
        }

        while(current1 != null && current2 != null) {
            if(current1.data <= current2.data) {
                tail.next = current1;
                tail = current1;
                current1 = current1.next;
            } else {
                tail.next = current2;
                tail = current2;
                current2 = current2.next;
            }

        }

        if(current1 != null) {
            tail.next = current1;
        } else {
            tail.next = current2;
        }
        return head;
    }

    static ListNode mergeListsRecursive(ListNode head1 , ListNode head2) {

        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        if (head1.data < head2.data) {
            head1.next = mergeListsRecursive(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeListsRecursive(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList list1 = new SinglyLinkedList();

            int list1Count = sc.nextInt();

            for (int i = 0; i < list1Count; i++) {
                int list1Item = sc.nextInt();
                list1.insertNode(list1Item);
            }

            SinglyLinkedList list2 = new SinglyLinkedList();

            int list2Count = sc.nextInt();


            for (int i = 0; i < list2Count; i++) {
                int list2Item = sc.nextInt();
                list2.insertNode(list2Item);
            }

            ListNode list3 = mergeListsRecursive(list1.head, list2.head);


            System.out.print("Recursive Call : ");
            printSinglyLinkedList(list3);


        }

    }

}
