package Queue;

public class CircularQueueUsingArray {

    private int front;
    private int rear;
    private final int capacity ;
    private static int[] circularQueue;

    public CircularQueueUsingArray(int c) {
        front = rear = -1;
        capacity = c ;
        circularQueue = new int[c];
    }

    private boolean isEmpty() {
        return front == -1 && rear == -1 ;
    }


    private boolean isFull() {
        return  ( rear + 1 ) % capacity == front;
    }

    private int getFront() {
        return circularQueue[front];
    }

    private int getLast() {
        return circularQueue[rear];
    }


    private void enqueue(int data) {

        if(isEmpty()) {
            front = rear = 0;
            circularQueue[rear] = data;

        }
        else if(isFull()) {
            System.out.println("queue is full ! cannot enqueue");
        }
        else {
            rear = (rear + 1) % capacity;
            circularQueue[rear] = data;
        }

    }


    private int dequeue() {

        if(isEmpty()) {
            System.out.println("queue is Empty ! nothing to dequeue");
            return 0;
        }
        int res = circularQueue[front];

        if(front == rear ) {
            front = rear = -1;
        }
        else {
            front = (front + 1) % capacity;
        }
        return res;

    }

    private void display() {
        if(isEmpty()) {
            System.out.println("Nothing to display");
            return;
        }
        int i = front;
        System.out.println("");
        while(i != rear) {
            System.out.print(circularQueue[i] + "<--");
            i = (i + 1) % capacity;
        }
        System.out.print(circularQueue[i]);
    }

    public static void main(String[] args) {

        CircularQueueUsingArray cqA = new CircularQueueUsingArray(4);

        cqA.display();

        cqA.enqueue(4);
        cqA.enqueue(5);
        cqA.enqueue(6);
        cqA.enqueue(7);

        cqA.display();

        cqA.dequeue();

        cqA.display();

    }

}