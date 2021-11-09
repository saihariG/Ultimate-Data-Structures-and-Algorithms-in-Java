package Arrays;

import java.util.Scanner;

public class IntegerReverse {
    private static void reverse(int num) {
        int reversed = 0, remainder ;

        while(num != 0) {
            remainder = num % 10; // reversed integer is stored in variable
            reversed = reversed * 10 + remainder; //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
            num  /= 10;  //the last digit is removed from num after division by 10.
        }
        System.out.println(reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        reverse(n);
    }
}
