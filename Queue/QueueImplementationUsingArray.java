package Queue;

public class QueueImplementationUsingArray {

      private int front;
      private int rear;
      private static int[] queue;

      public QueueImplementationUsingArray(int c) {
          front = -1;
          rear = -1;
          queue = new int[c];
      }

      private boolean isEmpty() {
          return front == -1 && rear == -1;
      }

      private boolean isFull() {
          return rear == queue.length - 1;
      }

      private int last() {
          return queue[rear];
      }

      private int front() {
          return queue[front];
      }

      private void display() {
          if(isEmpty()) {
              System.out.println("Queue is Empty");
              return;
          }
          for (int i = front ; i <= rear ; i ++) {
              System.out.println(queue[i] + "<--");
          }
      }

      private void enqueue(int data) {
          //check overflow
          if(isFull()) {
              System.out.print("Queue is Full");
              return;
          }

          //check underflow
          if(isEmpty()) {

              front = rear = 0;
              queue[rear] = data;
              return;
          }

          rear++;
          queue[rear] =data;

      }

      private int dequeue() {
          if(isEmpty()) {
              System.out.print("queue is Empty!nothing to dequeue");
              return 0;
          }

          if(front == rear) {
              int d = queue[front];
              front = rear =  -1 ;
              return d;
          }

          int dequeued = queue[front];
          front++;
          return dequeued;
      }


      public static void main(String[] args) {
          QueueImplementationUsingArray q = new QueueImplementationUsingArray(5);

          // print Queue elements
          q.display();

          // inserting elements in the queue
          q.enqueue(20);
          q.enqueue(30);
          q.enqueue(40);
          q.enqueue(50);

          // print Queue elements
          q.display();

          // insert element in the queue
          q.enqueue(60);

          // print Queue elements
          q.display();

          System.out.println(q.dequeue());
          System.out.println(q.dequeue());
          System.out.print("\n\nafter two node deletion\n\n");

          // print Queue elements
          q.display();

          // print front of the queue
          System.out.print(q.front());
          System.out.print(q.last());

      }


}
