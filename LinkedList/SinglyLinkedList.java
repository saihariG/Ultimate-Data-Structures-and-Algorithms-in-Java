package LinkedList;

public class SinglyLinkedList {

    //creating a node class
    //node -> a node contains a data and address of the next node
    private static class ListNode {

        private final int data;
        private ListNode next;

        public  ListNode(int data) {

            this.data = data ;
            this.next = null ;
        }

    }

    private  static ListNode head;

    /** Algorithm for counting length
     *  1. have a counter and initialize to zero
     *  2. create a new node current and initialize to head
     *  3. Traverse till the end of the list
     *  4. and increase the counter
      */
    private void length() {

        int counter = 0;
        ListNode current = head;

        while(current != null) {

            counter++;
            current = current.next;

        }

        System.out.println("\n"+"Length of list is :" + counter);
    }

    /** Algorithm
     * 1. create a new node current and initialize it to head
     * 2. initialize a counter variable to zero
     * 3. traverse until current is not null
     * 4. if data found return else traverse to next element
     *
     */
    private void Search(int SearchKey) {

        if(head == null) {

            System.out.println("SearchKey not found!!");
        }

        ListNode current = head ;
        int counter = -1;

        while (current != null) {

            counter ++ ;
            if(current.data == SearchKey) {

                System.out.println("SearchKey Found at " + counter + " node" );
                return;
            }

            current = current.next ;

        }
        System.out.println("SearchKey not Found!!");
    }

    private void display(ListNode head) {

        ListNode current = head ;
        while(current != null ) {

            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null");
    }

    /** Algo to insert node at beginning of the list
     * 1. create a new node and pass the data to be inserted
     * 2. now make its next to point head
     * 3. update head
     */
    private void insertFirst(int value) {

        ListNode newNode = new ListNode(value);
        newNode.next = head ;
        head = newNode ;

    }

    private void insertEnd(int value) {

        ListNode newNode = new ListNode(value);
        if (head == null) {

            head = newNode;
            return;
        }

        ListNode current = head ;
        while(current.next != null){

            current = current.next;
        }

        current.next = newNode;
    }

    private void findMiddleNode() {

        ListNode fastPtr = head ;
        ListNode slowPtr = head ;

        while (fastPtr != null && fastPtr.next != null) {

            slowPtr = slowPtr.next ;
            fastPtr = fastPtr.next.next;

        }

        assert slowPtr != null;
        System.out.println(slowPtr.data);

    }

    private ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);

        if(head == null) {
            return newNode;
        }

        ListNode current = head;
        ListNode temp = null;

        while (current != null && current.data < newNode.data) {

            temp = current ;
            current = current.next;
        }

        newNode.next = current;
        assert temp != null;
        temp.next = newNode ;

        return head;
    }

    private void getNthNodeFromEnd(int n) {

        if(head == null) {

            return ;
        }

        if(n <= 0) {

            throw  new IllegalArgumentException("Invalid Value:"+n);
        }

        ListNode mainPtr = head;
        ListNode refPtr = head ;

        int count = 0;
        while (count < n) {

            if(refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than number of nodes in the list");
            }

            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {

            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        System.out.println(mainPtr.data);
    }

    private ListNode reverseList() {

        ListNode current = head;
        ListNode previous = null;
        ListNode next ;

        while (current != null) {

            next = current.next ;
            current.next = previous ;
            previous = current ;
            current = next ;

        }

        return  previous;
    }

    private void deleteNode(int Key) {

        ListNode current = head;
        ListNode temp = null;

        if(current != null && current.data == Key) {

            head = current.next;
            return;
        }

        while (current != null && current.data != Key) {

            temp = current ;
            current = current.next;

        }

        if(current == null) {
            return;
        }

        temp.next = current.next;

    }

    private boolean detectLoop() {

        ListNode fastPtr = head ;
        ListNode slowPtr = head ;

        while (fastPtr != null && fastPtr.next !=null) {

            fastPtr = fastPtr.next.next ;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[]  args) {

          SinglyLinkedList sll = new SinglyLinkedList();
    }

}

