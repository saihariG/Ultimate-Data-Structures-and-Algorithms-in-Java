package Sorting;

import java.util.Scanner;

public class CountSort {


    private static void countSort(int[] array) {

        int n = array.length;

        // find the maximum element in array
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
             int item = array[i];
             if(item > max) {
                 max = item;
             }
        }


        int[] count = new int[max+1];
        // updating the occurrence of each item
        for(int i = 0 ; i < n ; i++) {
            int item = array[i];
            count[item]++;
        }

        // modify the count array to prefixSum array
        for(int i = 1 ; i < count.length ; i++) {
            count[i] = count[i] + count[i-1];
        }


        int[] output = new int[n];
        //for each element in original array find its correct position and put in output array
        for (int i = n-1 ; i >= 0 ; i--) {

             int item = array[i];

             int countIndex = --count[item] ;

             output[countIndex] = item;

        }

        //copy elements from output array to original array
        for(int i = 0 ; i < n ; i++) {
            array[i]  = output[i];
        }


    }


    private static void print(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
    }

    /***
     * sample input : 17
     *                2 1 1 0 2 5 4 0 2 8 7 7 9 2 0 1 9
     *
     */
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

        countSort(array);

        long endTime = System.nanoTime();

        System.out.print("\nAfter Sorting : ");
        print(array);

        long totalTime = endTime - startTime;

        System.out.printf("\nTime in seconds : %.6fs",(totalTime/ 1000000000.0));
        sc.close();
    }

}
