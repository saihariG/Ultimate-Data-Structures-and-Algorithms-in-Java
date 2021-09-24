package Searching;

import java.util.Scanner;

public class FirstOccurrence {

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


    //sample input : 1 3 3 3 4 4 6 6 6 6 7 7 7 8 8 11 15 22
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for(int i = 0 ; i < n ; i++) {
            array[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int index = firstOccurrence(array,target);

        System.out.println(index);
    }

}
