package Searching;

import java.util.Scanner;

public class BinarySearch {


    private static int binarySearch(int[] array , int target) {

        int n = array.length;
        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(target < array[mid]) {
                high = mid - 1;
            }
            else if(target > array[mid]) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for(int i = 0 ; i < n ; i++) {
            array[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int index = binarySearch(array,target);

        System.out.println(index);
    }

}
