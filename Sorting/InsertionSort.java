package Sorting;

import java.util.Scanner;

public class InsertionSort {

    private static void insertionSort(int[] array) {

        int n = array.length;

        for(int i = 1; i < n ; i++) {
            int temp = array[i];

            int j;
            for(j = i-1 ; j >= 0 && array[j] > temp ; j--) {
                   array[j+1] = array[j];
            }
            array[j + 1] = temp;
        }

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

        insertionSort(array);

        long endTime = System.nanoTime();

        System.out.print("\nAfter Sorting : ");
        print(array);

        long totalTime = endTime - startTime;

        System.out.printf("\nTime in seconds : %.6fs",(totalTime/ 1000000000.0));
        sc.close();
    }


}
