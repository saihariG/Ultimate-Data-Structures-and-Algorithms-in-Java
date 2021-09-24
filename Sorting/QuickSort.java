package Sorting;

import java.util.Scanner;

public class QuickSort {

    private static void quickSort(int[] array,int lb,int ub) {

         if(lb < ub) {
             int end  = partition(array,lb,ub);
             quickSort(array,lb,end-1);
             quickSort(array,end+1,ub);
         }
    }

    private static int partition(int[] array , int lb , int ub) {
         int pivot = array[lb];
         int start = lb;
         int end = ub;

         while (start < end) {
             while (array[start] <= pivot && start < array.length - 1) {
                 start++;
             }
             while (array[end] > pivot) {
                 end--;
             }
             if(start < end) {
                 swap(array,start,end);
             }
         }
         swap(array,lb,end);
         return end;
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

        quickSort(array,0,array.length-1);

        long endTime = System.nanoTime();

        System.out.print("\nAfter Sorting : ");
        print(array);

        long totalTime = endTime - startTime;

        System.out.printf("\nTime in seconds : %.6fs",(totalTime/ 1000000000.0));
        sc.close();
    }


}
