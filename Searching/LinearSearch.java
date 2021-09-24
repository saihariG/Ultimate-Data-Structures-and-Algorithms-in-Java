package Searching;

import java.util.Scanner;

public class LinearSearch {

    private static int linearSearch(int[] array , int target) {

        int n = array.length;

        for(int i = 0 ; i < n ; i++) {
            int item = array[i];

            if(item == target) {
                return i;
            }
        }

        return  -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] array = new int[n];

        for(int i = 0 ; i < n ; i++) {
            array[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int index = linearSearch(array,target);

        System.out.println(index);
    }

}
