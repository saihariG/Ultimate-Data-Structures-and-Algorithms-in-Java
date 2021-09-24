package Sorting;

import java.util.Scanner;

public class BubbleSort {

    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean isSwapped ;

        // n-1 -> no of passes
        for(int i = 0 ; i < n-1 ; i++) {
            isSwapped = false;
            for(int j = 0 ; j < n - 1 - i ; j++) {
                if(array[j] > array[j+1]) {
                    swap(array,j,j+1);
                    isSwapped = true;
                }
            }
            // if not swapped it means array is sorted , then no need of further sorting
            if(!isSwapped) {
                break;
            }
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

        bubbleSort(array);

        long endTime = System.nanoTime();

        System.out.print("\nAfter Sorting : ");
        print(array);

        long totalTime = endTime - startTime;

        System.out.printf("\nTime in seconds : %.6fs",(totalTime/ 1000000000.0));
        sc.close();
    }

}
