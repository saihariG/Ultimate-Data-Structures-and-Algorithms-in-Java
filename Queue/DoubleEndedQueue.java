package Queue;

public class DoubleEndedQueue {

    private int front , rear , capacity ;
    private static int[] Deque;

    public DoubleEndedQueue(int c) {
        front = rear = -1;
        capacity = c;
        Deque = new int[c];
    }

    private boolean isFull() {
        return (rear + 1) % capacity == front ;
    }

    private boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    private void enqueueFront(int data) {

        if(isFull()) {
            System.out.println("cannot enqueue front!");
        }
        else if(isEmpty()) {
            front = rear = 0;
            Deque[front] = data;
        }
        else if(front == 0) {
            front = capacity -1 ;
            Deque[front] = data;
        }
        else {
            front--;
            Deque[front] = data;
        }

    }

    private void enqueueRear(int data) {
        if(isFull()) {
            System.out.println("cannot enqueue rear!");
        }
        else if(isEmpty()) {
            front = rear = 0;
            Deque[rear] = data;
        }
        else if(rear == capacity - 1 ) {
            rear = 0;
            Deque[rear] = data;
        }
        else {
            rear++;
            Deque[rear] = data;
        }
    }

    private int dequeueFront() {
        if(isEmpty()) {
            System.out.println("nothing to dequeue Front");
            return 0;
        }
        else if(front == rear) {
            int res = Deque[front];
            front = rear = -1 ;
            return res;
        }
        else if(front == capacity - 1) {
            int res = Deque[front];
            front = 0;
            return res;
        }
        else {
            int res = Deque[front];
            front++;
            return res;
        }
    }

    private int dequeueRear() {
        if(isEmpty()) {
            System.out.println("nothing to dequeue rear");
            return 0;
        }
        else if(front == rear) {
            int res = Deque[rear];
            front = rear = 0;
            return res;
        }
        else if(rear == 0) {
            int res = Deque[rear];
            rear = capacity -1 ;
            return res;
        }
        else {
            int res = Deque[front];
            rear --;
            return res;
        }
    }


    public static void main(String[] args) {

        DoubleEndedQueue deque = new DoubleEndedQueue(5);



    }
}
