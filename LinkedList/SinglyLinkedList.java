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

    private void getNthNodeFromEnd1(int n) {

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

    private static int getNthNodeFromEnd2(int positionFromTail) {
        int index = 0;

        ListNode current = head;
        ListNode result = head;

        while(current != null)
        {
            current = current.next;

            if(index > positionFromTail)
            {
                result=result.next;
            }
            index++;
        }

        return result.data;
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

    // returns node where cycle begins
    private ListNode detectCycleNode() {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                ListNode current = head;
                while(current != slow) {
                    current = current.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    static boolean compareLists(ListNode head1, ListNode head2) {

        ListNode current1 = head1;
        ListNode current2 = head2;

        int length1 = 0;
        int length2 = 0;

        while(current1 != null && current2 != null) {
            if(current1.data != current2.data) {
                return false;
            }
            length1++;
            length2++;

            current1 = current1.next;
            current2 = current2.next;
        }

        return length1 == length2;

    }

    public static ListNode removeDuplicates(ListNode head) {
        // if list is empty or if list contains a single node
        if(head == null || head.next == null){
            return head;
        }

        // having a reference for head node and then manipulating it further
        ListNode current = head;

        // if head's next is null, it's the end of list
        while(head.next!=null){
            // checking head's data with its next data
            if(head.data != head.next.data){
                head = head.next;
            }else{
                head.next = head.next.next;
            }
        }
        return current;
    }


    public static void main(String[]  args) {

          SinglyLinkedList sll = new SinglyLinkedList();
    }

}

