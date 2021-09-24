package Heap;

public class MaxHeap {


    private static int[] heap;
    static int n;

    public MaxHeap(int capacity) {
        heap = new int[capacity + 1]; //since 0th index is ignored
        n = 0;
    }

    private boolean isEmpty() {
        return n==0;
    }

    private int size() {
        return n;
    }

    private void insert(int data) {
        
        if(n == heap.length - 1) {
            resize(2* heap.length);
        }
        
        n++;
        heap[n] = data;
        swim(n);

    }

    private void swim(int k) {
        while (k > 1 && heap[k/2] < heap[k]) {
            // performing swap
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2 ; // to continue shifting up
        }
    }

    private void resize(int capacity) {

        int[] temp = new int[capacity];

        for(int i = 1 ; i < heap.length ; i++) {
            temp[i] = heap[i];
        }

        heap = temp;
        
    }

    private static void printMaxHeap() {
        for (int i = 1 ; i <= n ; i++ ) {

            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(3);
        System.out.println(maxHeap.size());
        printMaxHeap();

    }

}
