package Queue;

public class circularQueueUsingLinkedList {

    private ListNode front ;
    private ListNode rear;
    private int length;

    static class ListNode {
        private final int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data ;
            this.next = null;
        }
    }

    public circularQueueUsingLinkedList() {
        front = rear = null;
        length = 0;
    }

    private int length() {
        return length;
    }

    private boolean isEmpty() {
        return length == 0 ;
    }

    private void display() {

        if(isEmpty()) {
            System.out.println("nothing to display");
            return;
        }

        System.out.println("");
        ListNode temp = front;
        while (temp != rear) {
            System.out.print(temp.data + "<--");
            temp = temp.next;
        }
        System.out.print(temp.data);

    }

    private void enqueue(int data) {
        ListNode newNode = new ListNode(data);


        if(isEmpty()) {
            front = newNode ;
        }
        else {
            rear.next = newNode;
        }
        rear = newNode;
        rear.next = front;
        length++;
    }

    private int dequeue() {
        if(isEmpty()) {
            System.out.println("nothing to dequeue");
            return 0;
        }
        int res = front.data;

        if(front == rear) {
            front = rear = null;
        }
        else {
            front = front.next;
            rear.next = front;
        }
        return res;
    }

    public static void main(String[] args) {

        circularQueueUsingLinkedList cqL = new circularQueueUsingLinkedList();
        cqL.display();
        cqL.enqueue(5);
        cqL.enqueue(10);
        cqL.display();
        cqL.enqueue(15);
        cqL.enqueue(20);
        cqL.display();
        cqL.dequeue();
        cqL.dequeue();
        cqL.display();
        System.out.println("\n"+cqL.rear.data);

    }

}
