package Heap;

public class MinHeap {

    static int[] heap;
    static int n;

    public MinHeap(int capacity) {
        heap = new int[capacity+1]; // since 0th index is ignored
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

        while (k > 1 && heap[k/2] > heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }

    private void resize(int l) {
        int[] temp = new int[l];

        for(int i = 0 ; i < heap.length ; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }

    private static void printMinHeap() {
        for (int i = 1 ; i <= n ; i++ ) {
            System.out.print(heap[i] + " ");
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(3);

        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(1);
        minHeap.insert(3);
        System.out.println(minHeap.size());
        printMinHeap();

    }

}
