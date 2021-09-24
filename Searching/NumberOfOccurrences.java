package Searching;

import java.util.Scanner;

public class NumberOfOccurrences {

    private static int firstOccurrence(int[] array , int target) {

        int n = array.length;
        int low = 0;
        int high = n-1;

        while (low < high) {

            int mid = (low + high) / 2;

            if(target > array[mid]) {
                low = mid + 1;
            }else {
                high = mid;
            }

        }

        if(array[low] == target) {
            return low;
        }
        else {
            return -1;
        }
    }

    private static int lastOccurrence(int[] array , int target) {

        int n = array.length;
        int low = 0;
        int high = n-1;

        while (low < high) {
            int mid = (low + high + 1) / 2;

            if(target < array[mid]) {
                high =  mid -1 ;
            }else {
                low  = mid;
            }
        }

        if(array[low] == target) {
            return low;
        }
        else {
            return -1;
        }
    }

    private static int numberOfOccurrences(int[] array , int target) {

        int first = firstOccurrence(array, target);
        int last = lastOccurrence(array,target);

        if(first == -1) {
            return -1;
        }
        else {
            return last - first + 1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for(int i = 0 ; i < n ; i++) {
            array[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int index = numberOfOccurrences(array,target);

        System.out.println(index);
    }


}
