package Sorting;

import java.util.Scanner;

public class SelectionSort {


    private static void selectionSort(int[] array) {
        int n = array.length;

        for(int i = 0 ; i < n - 1 ; i++) { // n-1 -> No of passes
            // assume 1st index holds the minimum element
            int minIndex = i;
            // finding the actual minimum element
            for(int j = i + 1 ; j < n ; j++) {
               if(array[j] < array[minIndex]) {
                   minIndex = j;
               }
            }
            // swapping the actual minimum element to front
            swap(array,i,minIndex);
        }
    }

    private static void swap(int[] array , int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void print(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i= 0 ; i < n ; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Before Sorting : ");
        print(array);

        long startTime = System.nanoTime();

        selectionSort(array);

        long endTime = System.nanoTime();

        System.out.print("\nAfter Sorting : ");
        print(array);

        long totalTime = endTime - startTime;

        System.out.printf("\nTime in seconds : %.6fs",(totalTime/ 1000000000.0));
        sc.close();
    }
}
