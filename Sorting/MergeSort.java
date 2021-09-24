package Sorting;

import java.util.Scanner;

public class MergeSort {

    private static void merge(int[] array,int lb,int mid,int ub) {
        int i = lb ;
        int j = mid+1 ;
        int k = lb;

        int[] sortedArray = new int[ub+1];

        while(i <= mid && j <= ub) {
            if(array[i] < array[j]) {
                sortedArray[k] = array[i];
                i++;
            }else {
                sortedArray[k] = array[j];
                j++;
            }
            k++;
        }

        if(i > mid) {
            while (j <= ub) {
                sortedArray[k] = array[j];
                j++;
                k++;
            }
        }else {
            while (i <= mid) {
                sortedArray[k] = array[i];
                i++;
                k++;
            }
        }

        for(k = lb ; k <= ub ; k++) {
            array[k] = sortedArray[k];
        }

    }

    private static void mergeSort(int[] array, int lb, int ub) {

        if(lb < ub)  {
            int mid = lb + (ub-lb) / 2 ;
            mergeSort(array,lb,mid);
            mergeSort(array,mid+1,ub);
            merge(array,lb,mid,ub);
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

        mergeSort(array,0,array.length-1);

        long endTime = System.nanoTime();

        System.out.print("\nAfter Sorting : ");
        print(array);

        long totalTime = endTime - startTime;

        System.out.printf("\nTime in seconds : %.6fs",(totalTime/ 1000000000.0));
        sc.close();
    }




}
